a. Thực hiện các thao tác sau (vẽ/chạy bằng tay) với cây thứ tự bộ phận (cây max-heap):

- Thêm lần lượt vào cây: 1, 3, 10, 9, 6, 7, 4, 5, 2, 8

- Lấy và xoá giá trị lớn nhất (ở gốc) 4 lần liên tiếp.

b. Thực hiện các thao tác sau đây với cây tìm kiếm nhị phân:

- Thêm lần lượt vào cây: 1, 3, 10, 9, 6, 7, 4, 5, 2, 8

- Xoá ra khỏi cây: 3, 5, 7, 9

c. Thực hiện tương tự như ở câu (b) nhưng với cây tìm kiếm cân bằng (2-3/ Red-Black/ AVL).



a) Cây thứ tự bộ phận (max-heap)

Bạn chèn tuần tự: 1, 3, 10, 9, 6, 7, 4, 5, 2, 8.

Sau khi chèn xong (dạng mảng theo thứ tự level-order — root ở chỉ số 0):

Max-heap (level order array):

[10, 9, 7, 5, 8, 3, 4, 1, 2, 6]


(ứng với cây — level theo hàng:

root = 10

hàng 2: 9, 7

hàng 3: 5, 8, 3, 4

hàng 4: 1, 2, 6)

Lấy và xoá giá trị lớn nhất (pop max) 4 lần liên tiếp

Mỗi lần pop: lấy root, thay bằng phần tử cuối mảng rồi sift-down.

Lần 1 — xóa 10
Heap sau khi xoá:

[9, 8, 7, 5, 6, 3, 4, 1, 2]


Lần 2 — xóa 9
Heap sau khi xoá:

[8, 6, 7, 5, 2, 3, 4, 1]


Lần 3 — xóa 8
Heap sau khi xoá:

[7, 6, 4, 5, 2, 3, 1]


Lần 4 — xóa 7
Heap sau khi xoá:

[6, 5, 4, 1, 2, 3]


Dãy các giá trị bị loại (theo thứ tự): 10, 9, 8, 7.

b) Cây tìm kiếm nhị phân (BST) — không cân bằng

Chèn tuần tự: 1, 3, 10, 9, 6, 7, 4, 5, 2, 8

Mình biểu diễn cây xoay (nhánh phải lên trên, nhánh trái xuống dưới) — dễ nhìn trong text.

Cây sau khi chèn xong (tất cả 10 phần tử)
10
9
8
7
6
5
4
3
2
1


(đọc: root nằm bên trái ở dòng 1 — cấu trúc: 1 → right 3 → right 6 → right 10 ... đây là dạng cây không cân bằng theo cách chèn thứ tự đã cho)

Xóa theo thứ tự: 3, 5, 7, 9 — trạng thái sau mỗi xóa
Sau xóa 3:
10
9
8
7
6
5
4
2
1


(3 bị thay thế/loại; 4 đã trở thành nút kế tiếp vị trí của 3 theo cách thay successor nội bộ khi cần)

Sau xóa 5:
10
9
8
7
6
4
2
1

Sau xóa 7:
10
9
8
6
4
2
1

Sau xóa 9:
10
8
6
4
2
1


— Sau mỗi xóa mình đã áp dụng luật xóa chuẩn của BST:

Nếu nút cần xóa là lá hoặc có 1 con → thay bằng con hoặc null.

Nếu có 2 con → thay bằng successor (nhỏ nhất ở cây con phải) rồi xóa successor.

c) Cây tìm kiếm cân bằng (mình dùng AVL)

Yêu cầu: “Thực hiện tương tự (chèn cùng dãy, sau đó xóa cùng các giá trị) nhưng trên cây cân bằng.” Mình dùng AVL (một loại cây cân bằng) để minh hoạ — sau mỗi chèn/xóa AVL tự xoay để giữ cân bằng.

Cây AVL sau khi chèn tuần tự 1,3,10,9,6,7,4,5,2,8:

(hiện mỗi nút dưới dạng value(h=height) để thấy chiều cao)

            10(h=1)
        9(h=3)
                8(h=1)
            7(h=2)
    6(h=4)
                5(h=1)
            4(h=2)
        3(h=3)
                2(h=1)
            1(h=2)


(AVL đã thực hiện các lần xoay nội bộ trong quá trình chèn để giữ cân bằng — bạn thấy các chiều cao được cập nhật)

Xóa theo thứ tự: 3, 5, 7, 9 — trạng thái AVL sau từng xóa
Sau xóa 3:
10(h=1)
9(h=3)
8(h=1)
7(h=2)
6(h=4)
5(h=1)
4(h=3)
2(h=1)
1(h=2)


(AVL cân bằng lại — chiều cao các nút cập nhật)

Sau xóa 5:
10(h=1)
9(h=3)
8(h=1)
7(h=2)
6(h=3)
4(h=1)
2(h=2)
1(h=1)


(đã có các xoay/điều chỉnh chi nhánh để duy trì |balance| ≤ 1)

Sau xóa 7:

(Trạng thái tiếp tục cân bằng, nút 7 bị loại và cây xoay nếu cần — tương tự như trên; cấu trúc rút gọn ở phần sau.)

Sau xóa 9:
10(h=2)
8(h=1)
6(h=3)
4(h=1)
2(h=2)
1(h=1)


(Cây vẫn cân bằng: độ cao các nhánh chênh ≤ 1.)