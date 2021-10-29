
public class StarCraftMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StarCraft[] sc = new StarCraft[3];
		
		sc[0] = new Zerg();
		sc[1] = new Terran();
		sc[2] = new Protos();
		
		sc[0].StarCraftString();
		sc[1].StarCraftString();
		sc[2].StarCraftString();
		
		sc[0].attack();
		sc[1].attack();
		sc[2].attack();

	}

}
