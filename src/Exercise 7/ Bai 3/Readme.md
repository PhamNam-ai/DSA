Tóm tắt: Sắp xếp danh sách sinh viên theo trật tự lần lượt là: a) Điểm (CGPA) càng cao càng tốt, b) tên theo trật tự chữ cái và c) mã (id) càng nhỏ càng tốt.

(Đã có sẵn mã lệnh cho nhập dữ liệu vào và in ra. Chỉ cần viết phần sắp xếp.)

Gợi ý: Xem link: Sort ArrayList of custom Objects by property trên StackOverFlow. Trước tiên, cần tạo lớp giúp so sánh hai sinh viên, dạng:
class StudentComparator implements Comparator<Student>
{
@Override
public int compare(Student x, Student y)
{
//Complete your code

        		return 0;
    		}
	}

Chú ý: Trong Java, so sánh xem String nào lớn hơn, dùng phương thức compareTo (vd: str1.compareTo(str2)).

Sau đó, trong chương trình chính, dùng phương thức Collections.sort() trong đó có sử dụng lớp so sánh đã tạo ở trên. Ví dụ:
Collections.sort(studentList, new StudentComparator());	
    
