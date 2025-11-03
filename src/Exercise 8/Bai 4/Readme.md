Tóm tắt: Các sinh viên sắp hàng, được phục vụ theo trật tự ưu tiên, lần lượt là: a) Điểm (CGPA) càng cao càng tốt, b) tên theo trật tự chữ cái và c) mã (token - id) càng nhỏ càng tốt.

Nếu lệnh là "ENTER" thì đưa sinh viên vào hàng; nếu là "SERVED" thì sinh viên được ưu tiên nhất (được phục vụ và) ra khỏi hàng.

Yêu cầu: In ra các sinh viên còn lại trong hàng, theo trật tự ưu tiên (cao xuống thấp). Nếu hàng rỗng, in ra "EMPTY".

Gợi ý: Xem link: How do I use a PriorityQueue ? trên StackOverFlow. Tham khảo bài Java Sort tuần trước. Trước tiên, cần tạo lớp giúp so sánh hai sinh viên, dạng:
class StudentComparator implements Comparator
{
@Override
public int compare(Student x, Student y)
{
//Complete your code

        	return 0;
    	}
	}

Chú ý: Trong Java, so sánh xem String nào lớn hơn, dùng phương thức compareTo (vd: str1.compareTo(str2)).

Sau đó, trong chương trình chính, tạo priority queue sử dụng lớp so sánh đã tạo ở trên. Ví dụ:
Comparator comparator = new StudentComparator();
Queue pq = new PriorityQueue(10, comparator);
