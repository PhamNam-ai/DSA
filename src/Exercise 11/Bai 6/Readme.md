Bài 6
Làm lại với yêu cầu mới bài Find the Running Median

Tóm tắt: Đọc lần lượt vào N số nguyên. Sau mỗi lần đọc vào số thứ i, in ra giá trị trung vị của i số đã nhập vào.
Với dãy có (2k + 1) số, thì giá trị trung vị bằng phần tử đứng giữa (có k số nhỏ hơn (hoặc bằng) nó, và đồng thời có k số lớn hơn (hoặc bằng) nó). Với dãy có (2k) phần tử, giá trị trung vị bằng trung bình cộng hai phần tử đứng giữa.

Yêu cầu: Trong thuật toán có sử dụng cây tìm kiếm nhị phân (Binary Search Tree)
Gợi ý:
Sử dụng TreeSet trong Java, với phương thức higher() và lower().
Để giải quyết vấn đề các số nguyên có thể bằng nhau, mỗi phần tử trong TreeSet có thể là một lớp gồm hai thuộc tính: giá trị số nguyên và thứ tự số nguyên đó.


Độ phức tạp tóm tắt

Thời gian: O(N log N) (N = số phần tử).

Mỗi phần tử thực hiện 1 add() O(log n) và có thể 1 poll() O(log n) khi cân bằng.

Bộ nhớ: O(N) để chứa 2 heap + kết quả.