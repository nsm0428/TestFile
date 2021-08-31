import java.util.*;

public class TestFile_main {
	static Scanner input = new Scanner(System.in);
	static ArrayList<DTO> list = new ArrayList<DTO>();
	static int countStd;

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
		System.out.println("등록을 선택하셨습니다.");
		System.out.print("이름 : ");
		String name = input.next();
		System.out.print("학번 : ");
		String StdNum = input.next();
		
		DTO dto = new DTO();
		dto.setName(name);
		dto.setStdNum(StdNum);
		
		list.add(dto);
		countStd++;
		
		System.out.println("등록이 완료되었습니다!");
		System.out.println("====================");
	}
	
	public static void searchStd() {
		System.out.println("검색을 선택하셨습니다.");
		System.out.println("어떤 항목으로 검색하시겠습니까?");
		System.out.println("1. 이름   2. 학번");
		int num = input.nextInt();
		
		if(num == 1) {
//			System.out.println(list.get(0).getName());
//			System.out.println(list.get(1).getName());
			System.out.println("이름으로 검색하겠습니다.");
			System.out.print("이름 : ");
			String name = input.next();
			System.out.println("검색 결과 입니다");
			
			for(int i = 0; i<list.size(); i++) {
				list.get(i).getName();
				if(name.equals(list.get(i).getName())) {
					System.out.println("검색하신 이름 : " + list.get(i).getName());
					System.out.println("검색하신 학번 : " + list.get(i).getStdNum());
					System.out.println("====================");
					break;
				}
			}
		}else if(num == 2) {
			System.out.println("학번으로 검색하겠습니다.");
			System.out.print("학번 : ");
			String StdNum = input.next();
			System.out.println("검색 결과 입니다");
			
			for(int i = 0; i<list.size(); i++) {
				list.get(i).getName();
				if(StdNum.equals(list.get(i).getStdNum())) {
					System.out.println("검색하신 이름 : " + list.get(i).getName());
					System.out.println("검색하신 학번 : " + list.get(i).getStdNum());
					System.out.println("====================");
					break;
				}
				
			}
		}else {
			System.out.println("없는 기능입니다.");
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
			
			for(int i = 0; i<list.size(); i++) {
				if(StdNum.equals(list.get(i).getStdNum())) {
					list.remove(i);
					System.out.println("성공적으로 삭제되었습니다!");
					countStd--;
					System.out.println("====================");
					break;
				}
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
