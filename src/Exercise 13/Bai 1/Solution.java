a) Vẽ đồ thị

Đồ thị có 8 đỉnh A,B,C,D,E,F,G,H với các cạnh (trọng số):

A–B 7,  A–C 6,  A–D 9,
B–C 2,  B–E 5,  B–F 10,
C–D 12, C–G 1,
D–G 14, D–H 20,
E–F 4,  E–H 13,
F–G 3,  F–H 8,
G–H 16


        (Cách vẽ nhanh trên giấy: đặt A ở trên cùng, D ở phải trên, H ở phải dưới, E ở trái dưới, rồi bố trí B,C,F,G xung quanh sao cho các cạnh trong danh sách trên không chồng quá lộn xộn. Không có hình vẽ thực tế ở đây nhưng danh sách cạnh đầy đủ để bạn vẽ.)

b) MST bằng Prim (bắt đầu từ A) — bước chính và kết quả

Quy trình (chỉ liệt kê các cạnh chọn theo thứ tự chọn):

Chọn từ A các cạnh nhỏ nhất → A–C (6).

Từ {A,C} chọn cạnh nhỏ nhất ra ngoài → C–G (1).

Từ {A,C,G} chọn → C–B (2).

Từ {A,B,C,G} chọn → G–F (3).

Từ {A,B,C,G,F} chọn → F–E (4).

Từ {A,B,C,G,F,E} chọn → F–H (8).

Còn D chưa vào → chọn A–D (9).

Kết quả MST (Prim): các cạnh

C–G (1), B–C (2), F–G (3), E–F (4), A–C (6), F–H (8), A–D (9)


Tổng trọng số MST = 33.

(Lưu ý: thứ tự lựa chọn có thể khác nhưng tập các cạnh MST và tổng trọng số là như trên.)

c) MST bằng Kruskal — bước chính và kết quả

Sắp các cạnh theo trọng số tăng dần rồi chọn (nếu không tạo chu trình):

Danh sách chọn theo Kruskal:

C–G (1)

B–C (2)

F–G (3)

E–F (4)

A–C (6)

F–H (8)

A–D (9)

Kết quả MST (Kruskal) — tập cạnh giống Prim:

C–G (1), B–C (2), F–G (3), E–F (4), A–C (6), F–H (8), A–D (9)


Tổng trọng số = 33.

d) Đường đi ngắn nhất A → H (Dijkstra)

Áp dụng Dijkstra từ đỉnh A tới H:

Đường đi ngắn nhất tìm được: A → C → G → F → H

Trọng số từng đoạn: A–C = 6, C–G = 1, G–F = 3, F–H = 8

Tổng chiều dài ngắn nhất = 6 + 1 + 3 + 8 = 18

        (Một vài đường thay thế có tổng lớn hơn: A–B–F–H = 7+10+8 = 25; A–D–H = 9+20 = 29, ...)