Tóm tắt: Cho N số nguyên (cookies) và ngưỡng K (độ ngọt).
Bước 1: Nếu số nhỏ nhất trong dãy nhỏ hơn K, lấy số đó ra - giả sử là m1. Sau đó tìm số nhỏ nhất trong các số còn lại - giả sử là m2. Thay số m2 bằng số có giá trị (m1 + 2 * m2).
Bước 2: Lặp lại bước 1 cho tới khi không còn số nào nhỏ hơn K.
Bước 3: Hãy in ra số lần thay số cần làm để tất cả các số còn lại lớn hơn hay bằng K. In ra -1 nếu không thể làm được.

Gợi ý: Đoạn mã sau nhập vào các giá trị N, K, rồi nhập tiếp các số nguyên (cookies) vào trong một hàng đợi ưu tiên (min priority queue - giúp lấy được giá trị nhỏ nhất). (/* Sau đó in ra các số theo thứ tự tăng dần. */)
Scanner scanner = new Scanner(System.in);
int N, K;
N = scanner.nextInt();
K = scanner.nextInt();

        Queue pqueue = new PriorityQueue(N);
        for (int i = 0; i < N; i++) {
            pqueue.add(scanner.nextInt());
        }
        
        /*
        while (pqueue.size() != 0) {
            System.out.println(pqueue.remove());
        }
        */

Link: How do I use a PriorityQueue ? trên StackOverFlow

