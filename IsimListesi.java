import java.util.Scanner;

public class IsimListesi {
	static Scanner input=new Scanner(System.in);
	static String[] isimler=new String[20];
	static int sonIndeks=0;
	static String secim;
	
	static void ekleme()
	{
		System.out.print("Ekleme: ");
		String isim=input.next();
		isimler[sonIndeks]=isim;
		sonIndeks++;
		System.out.println(isim+" eklendi.");
		listeleme();
	}
	
	static void silme() 
	{
		System.out.print("Silme: ");
		String silinecek=input.next();
		String[] guncelDizi=new String[20];
		int i=0;
		for(String isim:isimler) 
		{
			if(isim!=null) 
			{
				if(!isim.equals(silinecek)) 
				{
					guncelDizi[i]=isim;
					i++;
				}
			}
		}
		System.out.println("Silindi.");
		isimler=guncelDizi;
		sonIndeks--;
		listeleme();
	}
	
	static void degistirme() 
	{
		System.out.print("Deðiþtirme: ");
		int degisecekIndeks=input.nextInt();
		if(isimler[degisecekIndeks-1]!=null)
		{
			System.out.print("Yeni deðer: ");
			String yeniDeger=input.next();
			isimler[degisecekIndeks-1]=yeniDeger;
			System.out.println("Güncellendi.");
			listeleme();
		}
		else
			System.out.println("Deðiþtirme yapýlamaz.");
		
	}
	
	static void listeleme() 
	{
		System.out.println("\nMevcut Liste:");
		int siraNo=1;
		if(isimler[0]!=null) 
		{
			for(String isim:isimler) 
			{
				if(isim!=null) 
				{
					System.out.println(siraNo+"-"+isim);
					siraNo++;
				}
			}
		}
		else
			System.out.println("Liste boþ");
	}
	
	static void arama() 
	{
		System.out.print("Arama: ");
		String aranacak=input.next();
		int sira=0;
		for(String isim:isimler) 
		{
			if(isim!=null) 
			{
				if(isim.contains(aranacak)) 
				{
					sira++;
					System.out.println(sira+"-"+isim);
					
				} 
			}
		}
		if(sira==0)
			System.out.println("Bulunamadý.");
	}
	
	static String menu() 
	{
		System.out.println("\n---MENU---"
				+ "\nEkleme (E)"
				+ "\nSilme (S)"
				+ "\nDeðiþtirme (D)"
				+ "\nListele (L)"
				+ "\nArama (A)"
				+ "\nÇýkýþ (Ç)"
				+ "\n----------");
		System.out.print("\nSeçim: ");
		secim=input.next();
		return secim;
	}

	public static void main(String[] args) 
	{
		do 
		{
			secim=menu();
			if(!secim.equals("Ç")) 
			{
				switch(secim) 
				{
				case "E":
					ekleme();
					break;
				case "S":
					silme();
					break;
				case "D":
					degistirme();
					break;
				case "L":
					listeleme();
					break;
				case "A":
					arama();
					break;				
				}
			}
		}while(!secim.equals("Ç"));
		System.out.println("\nGüle güle...");
	}

}