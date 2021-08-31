import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TestFile_main {
	static Scanner input = new Scanner(System.in);
	static ArrayList<DTO> list = new ArrayList<DTO>();
	static int countStd;
	static File filepath;
	static DTO dto;
	

	public static void main(String[] args) {
		
		while(true) {
			System.out.println("실행하실 기능을 입력해주세요");
			System.out.println("1. 등록  2. 검색  3. 학생 수  4. 삭제  5. 종료");
			int num = input.nextInt();
			switch(num) {
			case 1:
				registerStd();
				break;
			case 2:
				searchStd();
				break;
			case 3:
				numberStd();
				break;
			case 4:
				deleteStd();
				break;
			case 5:
				System.out.println("종료합니다.");
				System.exit(0);
				break;
			}
		}
	}
	
	public static void registerStd() {
		DTO dto = new DTO();
		System.out.println("등록을 선택하셨습니다.");
		
		boolean bool = true;
		while(bool) {
			System.out.print("학번 : ");
			dto.setStdNum(input.next());
			filepath = new File("C:/직박구리/" + dto.getStdNum() + ".txt");
			if(filepath.isFile()) {
				System.out.println("존재하는 파일입니다.");
			}else {
				bool = false;
			}
		}
		
		
		System.out.print("이름 : ");
		dto.setName(input.next());
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filepath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(dto);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		countStd++;
		System.out.println("등록이 완료되었습니다!");
		System.out.println("====================");
	}
	
	public static void searchStd() {
		System.out.println("검색을 선택하셨습니다.");
		System.out.print("검색하실 학번을 입력해주세요 : ");
		String StdNum = input.next();
		filepath = new File("C:/직박구리/" + StdNum + ".txt");
		
		if(filepath.isFile()) {
			System.out.println("검색 결과 입니다.");
			try {
				FileInputStream fis = new FileInputStream(filepath);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				
				DTO d = (DTO)ois.readObject();
				System.out.println("학번 : " + d.getStdNum());
				System.out.println("이름 : " + d.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("없는 학번입니다.");
		}

	}
	
	public static void numberStd() {
		System.out.println("등록된 학생 수는 " + countStd + "명 입니다.");
		System.out.println("====================");
	}
	
	public static void deleteStd() {
		System.out.println("정말로 삭제기능을 실행하시겠습니까?");
		System.out.println("1. 네   2. 아니오");
		int num = input.nextInt();
		
		if(num == 1) {
			System.out.print("삭제할 학생의 학번을 입력해주세요 : ");
			String StdNum = input.next();
			filepath = new File("C:/직박구리/" + StdNum + ".txt");
			
			try {
				FileInputStream fis = new FileInputStream(filepath);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				
				DTO d = (DTO)ois.readObject();
				System.out.println("삭제할 학번 : " + d.getStdNum());
				System.out.println("삭제할 이름 : " + d.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("정말 삭제하시겠습니까?");
			System.out.println("1. 네   2. 아니오");
			int num1 = input.nextInt();
			
			if(num1 == 1) {
				filepath.delete();
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제하지않고 메인메뉴로 돌아갑니다.");
			}
			
			
		}else if(num == 2) {
			System.out.println("메인메뉴로 돌아갑니다.");
			System.out.println("====================");
		}else {
			System.out.println("없는 기능입니다.");
			System.out.println("====================");
		}
	}
	

}
