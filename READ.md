Add cell with a mouse click
	General structure of the code:
		In the Window library, there are two methods called getX() and getY() that are par to of a subclass of Window called mouse. These can be used to get the position of the cursor in relation to the screen (ex: int x = Window.mouse.getX())
		There is also a boolean method of mouse called clicked() (ex: if (Window.mouse.clicked())...)
		We will be using the combination of these two methods to add the ability to add cells
	Code: 
		Make new method called "add cell" that will also get called every time in the game loop
			In method: 
				Get coordinates of mouse
				Translate them to row and column (divide by the scale)
				Change the grid value at [col][row] to true

From here, I was planning on giving some examples of patters within the game (see here for examples: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life), and implementing them in code. The idea is to have a key presseded down when you click and it adds a pattern
	General Structure of the Code
		The library specific code for this is Window.key.pressed("key goes here") <-- boolean return value
			ex: if (Window.key.pressed("q")) {// add some structure}
	Code:
		Add another case within the if mouse clicked if statement in addCell() to check if a key is pressed
		Add the standard code to add the regular single cell as an else statement for this
		If this key is pressed, add the shape of the cells
			Probably best to ignore edge cases as to not confuse the kids, but if you want to include them, just check to make sure that the length of the width of the structure + the current row and col isn't less than 0 or greater than the length of the grid
		I did the block in my code, but the rest are really easy to add, it's the same outline, just changing where you add the live (true) cells on the grid to match the picture.
		
		
