import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {

	static ArrayList<Article> articles;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		articles = new ArrayList<>();
		Article a1 = new Article(1, "����1", "����1", "�͸�", getCurrentDate());
		Article a2 = new Article(2, "����2", "����2", "�͸�", getCurrentDate());
		Article a3 = new Article(3, "����3", "����3", "�͸�", getCurrentDate());

		articles.add(a1);
		articles.add(a2);
		articles.add(a3);

		int no = 4;

		while (true) {
			System.out.print("��ɾ� �Է� : ");
			String cmd = sc.next();
			if (cmd.equals("exit")) {
				System.out.println("����");
				break;
			}
			if (cmd.equals("add")) {

				Article a = new Article();
				
				a.setId(no);
				no++;
				System.out.println("�Խù� ������ �Է����ּ��� :");
				String title = sc.next();
				a.setTitle(title);

				System.out.println("�Խù� ������ �Է����ּ��� :");
				String body = sc.next();
				a.setBody(body);

				a.setRegDate(getCurrentDate());
				a.setNickname("�͸�");
				
				articles.add(a);
				System.out.println("�Խù��� ��ϵǾ����ϴ�.");

			}
			if (cmd.equals("list")) {
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					System.out.println("��ȣ : " + article.getId());
					System.out.println("���� : " + article.getTitle());
					System.out.println("��ϳ�¥ : " + article.getRegDate());
					System.out.println("�ۼ��� : " + article.getNickname());
					System.out.println("��ȸ��  : " + article.getHit());
					System.out.println("===================");
				}

			}
			if (cmd.equals("update")) {
// index 버전
//				System.out.println("������ �Խù� ���� : ");
//				int targetId = sc.nextInt();
//				if (targetId == -1) {
//					System.out.println("���� �Խù� �Դϴ�.");
//				} else {
//					System.out.println("�Խù� ������ �Է����ּ��� :");
//					String newTitle = sc.next();
//
//					System.out.println("�Խù� ������ �Է����ּ��� :");
//					String newBody = sc.next();
//
//					Article newArticle = new Article();
//					newArticle.setId(targetId);
//					newArticle.setTitle(newTitle);
//					newArticle.setBody(newBody);
//
//					articles.set(targetId, newArticle);
//					break;
//				}
				System.out.println("������ �Խù� ���� : ");
				int targetId = sc.nextInt();
				Article target = getArticleById(targetId);
				if (target == null) {
					System.out.println("���� �Խù� �Դϴ� ");
				} else {
					System.out.println("�Խù� ������ �Է����ּ��� :");
					String newTitle = sc.next();

					System.out.println("�Խù� ������ �Է����ּ��� :");
					String newBody = sc.next();
					
					target.setTitle(newTitle);
					target.setBody(newBody);
					
					break;
				}
			}
			if (cmd.equals("delete")) {
				System.out.println("������ �Խù� ���� : ");
				int targetId = sc.nextInt();
				Article target = getArticleById(targetId);
				if (target == null) {
					System.out.println("�Խù��� �����ϴ�.");
				} else {
					articles.remove(target);
				}
			}
			if (cmd.equals("read")) {
				System.out.println("�󼼺����� �Խù� ���� : ");
				int targetId = sc.nextInt();
				Article target = getArticleById(targetId);
				if (target == null) {
					System.out.println("�Խù��� �����ϴ�");
				} else {
					target.setHit(target.getHit() + 1);
					System.out.println("==== " + target.getId() + " ====");
					System.out.println("��ȣ : " + target.getId());
					System.out.println("���� : " + target.getTitle());
					System.out.println("���� : " + target.getBody());
					System.out.println("===============");
				}
			}
		}
	}
	// index 버전
	private static int getArticleIndexById(int targetId) {
		for (int i = 0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if (id == targetId) {
				return i;
			}
		}

		return -1;
	}
	
	// Article 버전
	private static Article getArticleById(int targetId) {
		for (int i = 0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if (id == targetId) {
				return articles.get(i);
			}
		}

		return null;
	}
	
	private static String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
		Date time = new Date();
		String time1 = format1.format(time);
		
		return time1;
	}
}
