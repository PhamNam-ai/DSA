Làm với nhiều cách bài Mising Numbers

Tóm tắt: Cho 2 danh sách A và B. (Chênh lệch giữa số lớn nhất và nhỏ nhất của B là không quá 100.) Tìm và in ra các số có trong B nhưng không có trong A theo trật tự tăng dần.

Yêu cầu: Làm bài này bằng 3 cách khác nhau. Phân tích độ phức tạp tính toán của mỗi phương pháp.

Gợi ý:

- Cách 1: Sử dụng bảng băm (Hash Tables) để đếm và tìm; sau đó sắp xếp để in ra.

- Cách 2: Chỉ sử dụng sắp xếp (Sorting) khi tìm và in ra.

- Cách 3: Sử dụng cách làm trong bài Sắp xếp đếm (Counting Sort)


CÁCH 1 — Dùng HashMap (Hash Table) đếm tần suất
🔹 Ý tưởng:

Dùng HashMap<Integer, Integer> để đếm số lần xuất hiện trong B (freqB)

Dùng HashMap<Integer, Integer> để đếm trong A (freqA)

Với mỗi phần tử trong B:

Nếu freqB.get(x) > freqA.getOrDefault(x, 0) → số bị thiếu.

🔹 Code:
public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
Map<Integer, Integer> freqA = new HashMap<>();
Map<Integer, Integer> freqB = new HashMap<>();

    for (int x : arr)
        freqA.put(x, freqA.getOrDefault(x, 0) + 1);

    for (int x : brr)
        freqB.put(x, freqB.getOrDefault(x, 0) + 1);

    List<Integer> missing = new ArrayList<>();
    for (int x : freqB.keySet()) {
        if (freqB.get(x) > freqA.getOrDefault(x, 0))
            missing.add(x);
    }

    Collections.sort(missing);
    return missing;
}


✅ Kết quả: [204, 205, 206]

🔹 Độ phức tạp:
Bước	Thời gian
Đếm tần suất A, B	O(n + m)
Duyệt so sánh	O(m)
Sắp xếp danh sách kết quả	O(k log k)
✅ Tổng	O(n + m + k log k)
Bộ nhớ	O(n + m)
🧮 CÁCH 2 — Dùng Sorting + Two Pointers
🔹 Ý tưởng:

Sắp xếp A và B.

Dùng hai con trỏ i, j:

Nếu A[i] == B[j] → cùng có → tăng cả 2.

Nếu A[i] < B[j] → A bị thiếu phần tử ở B → tăng i.

Nếu B[j] < A[i] → số B[j] bị thiếu trong A → thêm B[j] vào danh sách → tăng j.

Dừng khi hết một trong hai danh sách.

🔹 Code:
public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
Collections.sort(arr);
Collections.sort(brr);

    List<Integer> missing = new ArrayList<>();
    int i = 0, j = 0;

    while (j < brr.size()) {
        if (i < arr.size() && Objects.equals(arr.get(i), brr.get(j))) {
            i++;
            j++;
        } else {
            if (!missing.contains(brr.get(j)))
                missing.add(brr.get(j));
            j++;
        }
    }
    return missing;
}


✅ Kết quả: [204, 205, 206]

🔹 Độ phức tạp:
Bước	Thời gian
Sắp xếp A, B	O(n log n + m log m)
Duyệt hai con trỏ	O(n + m)
✅ Tổng	O(n log n + m log m)
Bộ nhớ	O(1) (nếu bỏ qua kết quả)
⚙️ CÁCH 3 — Dùng Counting Sort (do chênh lệch ≤ 100)
🔹 Ý tưởng:

Tìm minB, maxB → tạo mảng đếm countA và countB kích thước (maxB - minB + 1).

Đếm tần suất từng giá trị trong A và B theo chỉ số (x - minB).

Nếu countB[i] > countA[i] → giá trị (i + minB) bị thiếu.

🔹 Code:
public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
int min = Collections.min(brr);
int max = Collections.max(brr);
int range = max - min + 1;

    int[] countA = new int[range];
    int[] countB = new int[range];

    for (int x : arr)
        countA[x - min]++;
    for (int x : brr)
        countB[x - min]++;

    List<Integer> missing = new ArrayList<>();
    for (int i = 0; i < range; i++) {
        if (countB[i] > countA[i])
            missing.add(i + min);
    }
    return missing;
}


✅ Kết quả: [204, 205, 206]

🔹 Độ phức tạp:
Bước	Thời gian
Đếm A, B	O(n + m)
Duyệt so sánh	O(100) (vì max−min ≤ 100)
✅ Tổng	O(n + m)
Bộ nhớ	O(100) (rất nhỏ, cố định)
🧾 Tổng kết so sánh
Cách	Mô tả	Thời gian	Bộ nhớ	Ghi chú
1. Hash Table	Dùng HashMap đếm tần suất	✅ O(n + m)	O(n + m)	Linh hoạt, nhanh
2. Sorting	Sắp xếp rồi dùng 2 con trỏ	O(n log n + m log m)	O(1)	Không dùng thêm bộ nhớ
3. Counting Sort	Đếm theo chỉ số (khi range nhỏ)	✅ O(n + m)	O(100)	Cực nhanh khi range nhỏ

