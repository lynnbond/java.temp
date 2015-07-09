
public class MyTest {
	
	public static void main(String[] args) {
		//width
		int a = 800;
		//heigh
		int b = 600;
		//number of images
		int m = 2;
		//margin
		int margin = 5;
		
		a = a - 2 * margin;
		
		double x00 = Math.sqrt(a*b/(double)m); 

		System.out.println("x00: " + x00);
		
		int x0 = (int)x00;

		int col = a/x0;
		int row = b/x0;
		
		System.out.println("col: " + col);
		System.out.println("row: " + row);
		
		int x = x0;
		
		while(col*row < m) {
			int col_pre = col + 1;
			int row_pre = row + 1;
			
			int col_pre_x = a / col_pre;
			int row_pre_x = b / row_pre;
			
			System.out.println("-------new round-------");
			System.out.println("col_pre_x:" + col_pre_x);
			System.out.println("row_pre_x:" + row_pre_x);
			
			if(col_pre_x >= row_pre_x) {
				x = col_pre_x;
				col++;
				row = b / x;
				System.out.println("x  : " + x);
				System.out.println("col: " + col);
				System.out.println("row: " + row);
			} else {
				x = row_pre_x;
				row++;
				col = a / x;
				System.out.println("x  : " + x);
				System.out.println("col: " + col);
				System.out.println("row: " + row);
			}
		}

		System.out.println("=======The End=======");
		System.out.println("width:" + a);
		System.out.println("heigh:" + b);
		System.out.println("col: " + col);
		System.out.println("row: " + row);
		System.out.println("x  : " + x);
		System.out.println("col*x: " + col*x + " <= " + a);
		System.out.println("row*x: " + row*x + " <= " + b);
		System.out.println("col*row: " + col*row + " >= " + m);

	}
}
