Tóm tắt: Kiểm tra xem cây hiện tại có phải là cây tìm kiếm nhị phân hay không ?

Chú ý: Do lỗi của HackerRank, khi làm bài này phải chọn Java 7.

Gợi ý:
Cách 1: Duyệt cây theo thứ tự trong (in-order). Nếu dãy số (các giá trị khoá) thu được tăng dần thì đúng; nếu không là sai.
Cách 2: Sử dụng đệ qui. Cây tìm kiếm nhị phân khi:
a) Cây con trái và cây con phải cũng cùng là cây tìm kiếm nhị phân; và
b) Đỉnh cha có khoá lớn hơn khoá lớn nhất cây con bên trái và nhỏ hơn khoá nhỏ nhất cây 
