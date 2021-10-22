
public class Jumun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JJangke jj = new JJangke();
		jj.makeZazang();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		
		BackJJangke bj = new BackJJangke();
		bj.makeZazang();
		bj.makeZZambong();
		bj.makeOldZzang();
		
		System.out.println("============================================================");
		
		BackStreetJJangke bst = new BackStreetJJangke();
		
		bst.wonjoZazang();
		bst.makeOldZzang();
		
		System.out.println("================================================================");
		
		JJangke bst1 = new BackStreetJJangke();
		bst1.makeZazang();
		
		BackJJangke bst2 = new BackStreetJJangke();
		bst2.makeOldZzang();
		bst2.makeZazang();
		bst2.makeZZambong();
	}

}
