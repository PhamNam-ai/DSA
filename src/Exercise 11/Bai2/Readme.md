a .Chạy minh hoạ (vẽ/chạy bằng tay) bảng băm (hash table) dạng 'linear probing' (thăm dò tuyến tính) 'open addressing' (đánh địa chỉ mở) với:

- Mảng chứa các khoá có độ dài 17 phần tử.

- Khoá là các số nguyên.

- Chèn các khoá vào lần lượt là 3, 13, 6, 7, 23, 16, 33

- Tìm kiếm các khoá 6, 33, 40

b. Chạy minh hoạ (vẽ/chạy bằng tay) bảng băm (hash table) dạng 'separate chaining' có độ dài 17, với các thao tác:

- Chèn các khoá vào lần lượt là 3, 13, 6, 7, 23, 16, 33
- Tìm kiếm các khoá 6, 33, 40


A. Linear probing (open addressing) — bảng độ dài 17, h(k)=k mod 17

Dãy chèn: 3, 13, 6, 7, 23, 16, 33

Bắt đầu với mảng 17 ô, tất cả rỗng.

Chèn 3:
h(3)=3 → ô 3 rỗng → đặt 3 tại index 3.

Chèn 13:
h(13)=13 → ô 13 rỗng → đặt 13 tại index 13.

Chèn 6:
h(6)=6 → ô 6 rỗng → đặt 6 tại index 6.

Chèn 7:
h(7)=7 → ô 7 rỗng → đặt 7 tại index 7.

Chèn 23:
h(23)=23 mod17 = 6 → ô 6 bị chiếm (chứa 6), probe tiếp → index 7 (bị chiếm bởi 7) → probe tiếp → index 8 rỗng → đặt 23 ở 8.

Chèn 16:
h(16)=16 → ô 16 rỗng → đặt 16 tại index 16.

Chèn 33:
h(33)=33 mod17 = 16 → ô 16 bị chiếm (16), probe → (wrap) index 0 rỗng → đặt 33 ở 0.

Mảng sau khi chèn (index : value):

0 : 33
1 : -
2 : -
3 : 3
4 : -
5 : -
6 : 6
7 : 7
8 : 23
9 : -
10: -
11: -
12: -
13: 13
14: -
15: -
16: 16


("-" = rỗng)

Tìm kiếm (linear probing)

Tìm 6:
h(6)=6 → kiểm tra index 6: thấy 6 → Found.
Số probe: 1 (index 6).

Tìm 33:
h(33)=16 → kiểm tra index 16: chứa 16 ≠ 33 → probe tiếp → index 0: chứa 33 → Found.
Số probe: 2 (indices 16 → 0).

Tìm 40:
h(40)=40 mod17 = 6 → kiểm tra index 6: 6 ≠ 40 → probe 7: 7 ≠ 40 → probe 8: 23 ≠ 40 → probe 9: rỗng → gặp ô rỗng → Not Found.
Số probe tới khi dừng: 4 (6 → 7 → 8 → 9 (rỗng) ⇒ dừng).

B. Separate chaining — bảng độ dài 17 (mỗi ô là danh sách / bucket)

Dùng cùng hàm băm h(k)=k mod 17. Mỗi bucket giữ một chuỗi (ở đây mình liệt kê theo thứ tự chèn — thêm vào cuối chuỗi).

Chèn tuần tự: 3, 13, 6, 7, 23, 16, 33

3 → h=3 → bucket[3]: [3]

13 → h=13 → bucket[13]: [13]

6 → h=6 → bucket[6]: [6]

7 → h=7 → bucket[7]: [7]

23 → h=6 → bucket[6] hiện [6] → thêm vào: [6 -> 23]

16 → h=16 → bucket[16]: [16]

33 → h=16 → bucket[16] hiện [16] → thêm vào: [16 -> 33]

Buckets (sơ lược các index có dữ liệu):

bucket[0]:  -
bucket[1]:  -
bucket[2]:  -
bucket[3]:  3
bucket[4]:  -
bucket[5]:  -
bucket[6]:  6 -> 23
bucket[7]:  7
bucket[8]:  -
...
bucket[13]: 13
...
bucket[16]: 16 -> 33

Tìm kiếm (separate chaining)

Tìm 6:
h(6)=6 → vào bucket[6]: danh sách [6 -> 23] → kiểm tra phần tử đầu 6 → Found.
Số bước (kiểm tra node): 1.

Tìm 33:
h(33)=16 → bucket[16]: [16 -> 33] → kiểm tra 16 (không phải), tiếp 33 → Found.
Số bước: 2 (kiểm tra 2 node).

Tìm 40:
h(40)=6 → bucket[6]: [6 -> 23] → kiểm tra 6, 23 đều ≠ 40 → hết danh sách → Not Found.
Số bước: 2 (kiểm tra 2 node rồi kết luận).