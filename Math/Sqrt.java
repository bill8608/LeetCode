public class Sqrt {
	/*
	//This only works for x where (x/2)^2 < 2^31
    public int Sqrt(int x) {
        int start = 0, end = x;
        while (end - start > 1) {
            int mid = (end + start) / 2;
            if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return (end * end == x)? end:start;
    }
	*/
	
	//Newton recursion
	public int Sqrt(int x) {
		double d = (double) x; // target, to get SquareRoot of target
        double g = 1;
        double e = 0.1; // precision
        while (Math.abs(g - d/g) > e) {
            g = (g + d/g) / 2;
        }
        return (int) g;
    }
	
	
	public static void main(String[] args) {
		Sqrt sqrt1 = new Sqrt();
		/*
		for (int i = 0; i <=100; ++i) {
			System.out.println(sqrt1.Sqrt(i));
		}
		*/
		System.out.println(sqrt1.Sqrt(Integer.MAX_VALUE));
	}
}