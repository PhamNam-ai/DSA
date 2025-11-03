Trong hai thuật toán sắp xếp Chọn (Insertion sort) và Chèn/Xen vào (Selection Sort), dữ liệu đầu vào có nên lưu trong LinkedList (danh sách liên kết) không ? Vì sao ?

Không nên lưu dữ liệu đầu vào trong LinkedList khi sử dụng hai thuật toán Chọn (Selection Sort) và Chèn (Insertion Sort).
Lý do:
- Cả hai thuật toán này đều cần truy cập ngẫu nhiên (random access) đến các phần tử trong danh sách, trong khi LinkedList không hỗ trợ truy cập ngẫu nhiên, việc truy cập phần tử thứ i mất thời gian O(n).
- Ngược lại, mảng (Array hoặc ArrayList) cho phép truy cập trực tiếp phần tử chỉ với O(1), giúp các phép so sánh và hoán đổi diễn ra nhanh hơn nhiều.
- Vì vậy, nên dùng mảng (Array hoặc ArrayList) để lưu dữ liệu đầu vào cho hai thuật toán này thay vì LinkedList.