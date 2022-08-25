package problems;

public class Problems {
	
	static class Idx {
        Integer idx;
        Idx(Integer n){
            this.idx = n;
        }
    }

	static void updater(Idx indx) {
		if(indx.idx==5) {
			indx.idx++;
			return;
		}
		System.out.println(indx.idx);
		indx.idx++;
		updater(indx);
		System.out.println(indx.idx);
		
	}
	
	public static void main(String[] args) {
		
		Idx indx = new Idx(0);
		Integer n = 0;
		System.out.println(indx.idx);
		updater(indx);
		System.out.println(indx.idx);
		
	}

}
