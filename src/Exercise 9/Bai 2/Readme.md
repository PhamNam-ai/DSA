Tóm tắt: Trước tiên, nhập vào danh sách tên người cùng số điện thoại. Sau đó, với mỗi câu hỏi có tên người, in ra số điện thoại tương ứng; Nếu không có người nào có tên đó, thì in ra "Not found".
Gợi ý: Sử dụng Map (tức bảng ký hiệu) có trong Java. Các mã sau là ví dụ về Map:
// Khai báo 1 Map với khoá String và giá trị Integer
Map people = new HashMap();
//...
// Thêm người có tên với số điện thoại vào map
people.put(name, phone);
//...
// Kiểm tra nếu có người trong map thì in ra tên và điện thoại, nếu không in ra "Not found"
if (people.containsKey(s)) System.out.println(s + "=" + people.get(s));
else System.out.println("Not found");      
    
