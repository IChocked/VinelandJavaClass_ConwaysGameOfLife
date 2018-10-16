
public class Runner {

	static int scale = 10;
	static boolean grid[][] = new boolean[500 / scale][500 / scale];

	public static void main(String[] args) {
		Window.size(500, 500);
		Window.out.background("white");

		// Assign a random value to every place in the grid
		// either a living cell or not, completely random
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (Math.random() < 0.5) {
					grid[row][col] = false;
				} else {
					grid[row][col] = true;
				}
			}
		}

		while (true) {
			// NEW: the method to add cells on mouse click
			addCell();
			// make it draw
			draw();
			// make it move update everything in our game
			update();
			// Refreshing
			Window.frame();

		}

	}

	public static void addCell() {
		// if the mouse if clicked
		if (Window.mouse.clicked()) {
			
			// get the coordinates of the click
			int x = Window.mouse.getX();
			int y = Window.mouse.getY();

			// translate the coordinates into scaled rows and columns; how we will find it
			// in our grid
			int col = x / scale;
			int row = y / scale;
			
			// this is for the block structure/pattern
			if (Window.key.pressed("b")) {
				//change the actual grid to make the desired pattern
					// in this case a 2x2 grid
				grid[col][row] = true;
				grid[col + 1][row] = true;
				grid[col][row + 1] = true;
				grid[col + 1][row + 1] = true;
			}
			// if no special patterns are being used, we still want to add the single cell as a basic click
			else {
				// create a new cell if there is not one already there
				grid[col][row] = true;
			}
		}
	}

	public static void draw() {
		// cells and dots
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == true) {
					// draw it
					Window.out.color("white");
					Window.out.square(row * scale, col * scale, scale);
				} else {
					// don't want to draw it
				}
			}
		}
	}

	public static void update() {

		// play out the simulation
		// go through each cell and if dead or alive
		// follow the four rules

		// 1 is create a copy of the grid
		boolean copy[][] = new boolean[500 / scale][500 / scale];

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {

				copy[row][col] = grid[row][col];
			}
		}

		// 2 determine the number of neighbors (max of 8)
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {

				int neighbors = 0;

				// up and to the left
				if (row != 0 && col != 0 && grid[row - 1][col - 1] == true) {
					neighbors = neighbors + 1;
				}
				// directly up
				if (row != 0 && grid[row - 1][col] == true) {
					neighbors = neighbors + 1;
				}
				// up and to the right
				if (row != 0 && col < grid.length - 1 && grid[row - 1][col + 1] == true) {
					neighbors = neighbors + 1;
				}
				// directly right
				if (col < grid.length - 1 && grid[row][col + 1] == true) {
					neighbors = neighbors + 1;
				}
				// down and to the right
				if (col < grid.length - 1 && row < grid.length - 1 && grid[row + 1][col + 1] == true) {
					neighbors = neighbors + 1;
				}
				// directly down
				if (row < grid.length - 1 && grid[row + 1][col] == true) {
					neighbors = neighbors + 1;
				}
				// down and to the left
				if (row < grid.length - 1 && col != 0 && grid[row + 1][col - 1] == true) {
					neighbors = neighbors + 1;
				}
				// directly left
				if (col != 0 && grid[row][col - 1] == true) {
					neighbors = neighbors + 1;
				}

				// 3 test the number of neighbors with the rules
				// rule 1
				if (neighbors < 2) {
					copy[row][col] = false;
				}
				// rule 3
				else if (neighbors > 3) {
					copy[row][col] = false;
				}
				// rule 4
				else if (neighbors == 3) {
					copy[row][col] = true;
				}
			}
		}

		grid = copy;

		// 4 update the cell in the next generation (alive or dead)
	}
}
