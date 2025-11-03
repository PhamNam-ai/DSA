Tóm tắt: Cài đặt thuật toán QuickSort. In ra toàn bộ mảng các số cứ sau mỗi lần thực hiện partition (mỗi lần phân chia).

Chú ý: Việc partition ở đây cần phải sử dụng phương pháp Lomuto Partitioning. Phương pháp này đơn giản hơn và chậm hơn phương pháp của Hoare học trên lớp (xem tại Wikipedia). Mã của Lomuto Partitioning như sau:
algorithm partition(A, low, high) is
pivot := A[high]
i := low        // place for swapping
for j := low to high – 1 do
if A[j] ≤ pivot then
swap A[i] with A[j]
i := i + 1
swap A[i] with A[high]
return i	
