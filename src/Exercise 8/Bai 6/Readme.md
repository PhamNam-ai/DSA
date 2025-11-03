Tóm tắt: Đọc lần lượt vào N số nguyên. Sau mỗi lần đọc vào số thứ i, in ra giá trị trung vị của i số đã nhập vào.
Với dãy có (2k + 1) số, thì giá trị trung vị bằng phần tử đứng giữa (có k số nhỏ hơn (hoặc bằng) nó, và đồng thời có k số lớn hơn (hoặc bằng) nó). Với dãy có (2k) phần tử, giá trị trung vị bằng trung bình cộng hai phần tử đứng giữa.

Gợi ý: Chia dãy đang được nhập vào làm 2 phần có số phần tử tương đương, và lưu tương ứng vào 2 hàng đợi ưu tiên.

Đoạn mã sau giúp khai báo 2 hàng đợi ưu tiên chứa các số nguyên; một hàng đợi là min priority queue giúp có được phần tử nhỏ nhất và một hàng đợi là max priority queue giúp có được phần tử lớn nhất.
Scanner scanner = new Scanner(System.in);
int N;
N = scanner.nextInt();
Queue maxPQ = new PriorityQueue(N/2 + 1, Collections.reverseOrder());
Queue minPQ = new PriorityQueue(N/2 + 1);


Giả sử priorityQueue là một hàng đợi ưu tiên các số nguyên. Lệnh sau đọc (nhưng không xoá đi) phần tử đầu hàng đợi, in ra dưới dạng (format) có một số thập phân sau dấu phẩy.
System.out.printf("%.1f\n", (double) priorityQueue.peek());


Hãy phân tích độ phức tạp tích toán của thuật toán.

| Thao tác                       | Độ phức tạp  |
| ------------------------------ | ------------ |
| Thêm phần tử vào PriorityQueue | **O(log N)** |
| Xóa đỉnh (poll)                | **O(log N)** |
| Lấy đỉnh (peek)**              | **O(1)**     |
| Cân bằng hai heap              | **O(log N)** |
