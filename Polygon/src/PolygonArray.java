import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PolygonArray {

	public Polygon[] polys = new Polygon[100];
	
	public PolygonArray() {
		
	}
	
	public PolygonArray(String fname, int nsides) throws IOException{
		Scanner x = null;
		
		x = new Scanner(new File(fname));
		
		double rn = Math.random();
		
		int c = 0;
		int pc = 0;
		
		Point [] pts = new Point[nsides];
		
		Double a = 0.0;
		Double b = 0.0;
		
		int i = 0;
		Double d = 0.0;
		
		while (x.hasNext()) {
			
			if (c % 2 == 0) {
				a = x.nextDouble();
			} else if (c % 2 == 1) {
				b = x.nextDouble();
				pts[i] = new Point(a,b); 
				System.out.println(pts[i]);
				
				i++;
			} 
			
			if ((c+1)%(2*nsides) == 0) {
				this.polys[pc] = new Polygon(pts);
				//System.out.println(this.polys[pc]);
				pc++;
				i = 0;
			}
			
			if (c == 200 * nsides) {
				
				break;
			}
			
			c ++;
		}
		
		System.out.println(this.polys[0].toString());
	
		
		x.close();
	}
	
	public PolygonArray(int r) {
		for(int i = 0; i < 100; i++) {
			this.polys[i] = new Polygon(0);
		}
	}

}
