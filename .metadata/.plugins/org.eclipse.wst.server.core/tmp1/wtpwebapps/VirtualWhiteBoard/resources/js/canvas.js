var drawMode;
var shape;
var origX, origY;
var isDown, isImageMode;

var canvas;

var width = 1;
var color = "black"; 
var lastPenColor = "black";
var lastPenWidth = 1;
var lastPenOpacity = 1;

var unlockedimgs = [];

var shapeCounter = 0;

var isLastShapeText = false;
var lastText;


$(document).ready(function() {
	
	canvas = new fabric.Canvas('c', {
	    selection: false
	});
	
	canvas.freeDrawingBrush = new fabric['PencilBrush'](canvas);
	
	//sets default draw mode
	drawMode = "free";
	canvas.isDrawingMode = true;
	canvas.freeDrawingBrush.color = lastPenColor;
	canvas.freeDrawingBrush.width = lastPenWidth;

	
	canvas.on('mouse:down', function(o) {
		if (isImageMode == true) {
			return;
		}
		
		if (isLastShapeText == true) {
			lastText.selectable = false;
			isLastShapeText = false;
		}
		
		isDown = true;
		var pointer = canvas.getPointer(o.e);
		origX = pointer.x;
		origY = pointer.y;


		// create a shape depend on the draw mode
		if (drawMode == "rectangle") {
			canvas.isDrawingMode = false;
			
			shape = new fabric.Rect({
				left : origX,
				top : origY,
				originX : 'left',
				originY : 'top',
				width : pointer.x - origX,
				height : pointer.y - origY,
				fill: color,
				//opacity: opacity
			});
			canvas.add(shape);
		} else if (drawMode == "ellipse") {
			canvas.isDrawingMode = false;
			
			shape = new fabric.Ellipse({
				left : origX,
				top : origY,
				originX : 'left',
				originY : 'top',
				fill: color,
				//opacity: opacity
			});
			canvas.add(shape);
		} else if (drawMode == "triangle") {
			canvas.isDrawingMode = false;

			shape = new fabric.Triangle({
				left : origX,
				top : origY,
				originX : 'left',
				originY : 'top',
				width: 1,
		        height: 1,
		        fill: color,
		        //opacity: opacity

			});
			canvas.add(shape);
		} else if (drawMode == "free") {
			canvas.isDrawingMode = true;
			
		} else if (drawMode == "line") {
			canvas.isDrawingMode = false;
			var points = [ pointer.x, pointer.y, pointer.x, pointer.y ];
			shape = new fabric.Line(points, {
				strokeWidth: lastPenWidth,
			    fill: color,
			    stroke: color,
				originX: 'center',
				originY: 'center',
				//opacity: opacity
			});
			canvas.add(shape);
		} else if (drawMode == "eraser") {
			canvas.isDrawingMode = true;
			
		} else if (drawMode == "text") {
			
			canvas.isDrawingMode = false;
			shape = new fabric.Textbox("",{
	            left: origX,
	            top: origY,
	            fill: color
	        });
			canvas.add(shape);
			lastText = shape;
			canvas.setActiveObject(shape);
			shape.enterEditing();
			shape.hiddenTextarea.focus();
			isLastShapeText = true;
		}

	});

	//change the shape size dynamically based on the coordinate of the mouse event
	canvas.on('mouse:move', function(o) {
		if (isImageMode == true) {
			return;
		}
		
		var pointer = canvas.getPointer(o.e);
		if (!isDown) {
			return;
		}

		if (drawMode == "rectangle") {

			if (origX > pointer.x) {
				shape.set({
					left : Math.abs(pointer.x)
				});
			}
			if (origY > pointer.y) {
				shape.set({
					top : Math.abs(pointer.y)
				});
			}

			shape.set({
				width : Math.abs(origX - pointer.x)
			});
			shape.set({
				height : Math.abs(origY - pointer.y)
			});

		} else if (drawMode == "ellipse") {
			if (origX > pointer.x) {
				shape.set({
					left : Math.abs(pointer.x)
				});
			}

			if (origY > pointer.y) {
				shape.set({
					top : Math.abs(pointer.y)
				});
			}

			shape.set({
				rx : Math.abs((origX - pointer.x) / 2),
				ry : Math.abs((origY - pointer.y) / 2)
			});

		} else if (drawMode == "triangle") {
			

			shape.set({
				left: Math.min(pointer.x, origX),
		        top: Math.min(pointer.y, origY),
				width : Math.abs(origX - pointer.x),
				height : Math.abs(origY - pointer.y)
			});
			
		} else if (drawMode == "free") {
			canvas.isDrawingMode = true;
			
		} else if (drawMode == "line") {
			shape.set({
				x2: pointer.x,
				y2: pointer.y
			});
		}
		
		canvas.renderAll();
	});

	//finish drawing the shape
	canvas.on('mouse:up', function(o) {
		if (isImageMode == true) {
			return;
		}
		isDown = false;
		canvas.item(shapeCounter).selectable = false;
		shapeCounter++;
		
	});
	
	$(document).keyup(function(e) {
		//esc  
		if (e.keyCode == 27) {
			if (isLastShapeText == true) {
				lastText.selectable = false;
				isLastShapeText = false;
			}
		}
	});
	
	
	//if an image has been uploaded, add the image to the canvas
	$("#file").on("change", function (e) {
		var file = e.target.files[0];
        var reader = new FileReader();
        reader.onload = function (f) {
            var data = f.target.result;
            fabric.Image.fromURL(data, function (img) {
            	
            	//scale the image
            	var widthScaleSize = 1;
            	var heightScaleSize = 1;
            	if (img.width > canvas.width) {
            		widthScaleSize = canvas.width / img.width;
            	}
            	if (img.height > canvas.height) {
            		heightScaleSize = canvas.height / img.height;
            	}
            	if (widthScaleSize < 1 || heightScaleSize < 1) {
            		img = img.scale(Math.min(widthScaleSize, heightScaleSize));
            	}
            	canvas.add(img).renderAll();
            	unlockedimgs.push(img);
                //canvas.setActiveObject(img);
                //var dataURL = canvas.toDataURL({format: 'png', quality: 0.8});
            	//var oImg = img.set({left: 70, top: 100, width: 250, height: 200, angle: 0}).scale(0.9);
            });
        };
        reader.readAsDataURL(file);
        shapeCounter++;
    });
	
	
	//read the draw mode based on the button
	$("#pen").click(function(){
		if (isImageMode == true) {
			return;
		}
		
		drawMode = "free";
		canvas.isDrawingMode = true;
		canvas.freeDrawingBrush.color = lastPenColor;
		canvas.freeDrawingBrush.width = lastPenWidth;
		canvas.freeDrawingBrush.opacity = lastPenOpacity;
		
	});
	
	$("#line").click(function(){
		drawMode = "line";
		canvas.isDrawingMode = false;
	});
	
	$("#rectangle").click(function(){
		drawMode = "rectangle";
		canvas.isDrawingMode = false;
	});

	$("#circle").click(function(){
		drawMode = "ellipse";
		canvas.isDrawingMode = false;
	});
	
	$("#triangle").click(function(){
		drawMode = "triangle";
		canvas.isDrawingMode = false;
	});
	
	$("#clear").click(function(){
		canvas.clear();
		shapeCounter = 0;
		isImageMode = false;
	});
	
	$("#undo").click(function(){
		if (shapeCounter > 0) {
			canvas.getObjects()[shapeCounter - 1].remove();
			shapeCounter--;
		}
	});
	
	$("#eraser").click(function(){
		if (isImageMode == true) {
			return;
		}

		drawMode = "eraser";
		canvas.isDrawingMode = true;
		canvas.freeDrawingBrush.width = width;
		canvas.freeDrawingBrush.color = 'white';
	});
	
	$("#text").click(function(){
		drawMode = "text";
	});
	
	$("#file").click(function(){
		isImageMode = true;
		canvas.isDrawingMode = false;
	});
	
	$("#lockimgs").click(function(){
		for (var i = 0; i < unlockedimgs.length; i++) {
			unlockedimgs[i].selectable = false;
		}
		isImageMode = false;
	});
	

});

//read the new color and width selected by user
function updateColour(selectedColour) {
	color = "#" + selectedColour;
	canvas.freeDrawingBrush.color = color;
	lastPenColor = color;
}

function updateWidth(selectedWidth) {
	width = parseInt(selectedWidth);
	canvas.freeDrawingBrush.width = width;
	lastPenWidth = width;
}

function updatePenStyle(selectedStyle) {
	canvas.freeDrawingBrush = new fabric[selectedStyle + 'Brush'](canvas); 
}

/*function updateOpacity(selectedOpacity) {
	opacity = selectedOpacity;
	canvas.freeDrawingBrush.opacity = opacity;
	lastPenOpacity = opacity;
}*/