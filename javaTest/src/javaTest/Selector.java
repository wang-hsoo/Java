package javaTest;

public class Selector {
	  private String name = "";
	   private int price = 0;
	   
	   public Selector(int sel) {
	      switch (sel) {
	      case 1:
	         this.name = "�ݶ�";
	         this.price = 600;
	         break;
	         
	      case 2:
	         this.name = "ȯŸ";
	         this.price = 550;
	         break;
	         
	      case 3:
	         this.name = "Ŀ��";
	         this.price = 370;
	         break;
	         
	      case 4:
	         this.name = "��";
	         this.price = 420;
	         break;

	      default:
	         break;
	      }
	   }
	   
	   public String getName() {
	      return name;
	   }
	   
	   public int getPrice() {
	      return price;
	   }

}
