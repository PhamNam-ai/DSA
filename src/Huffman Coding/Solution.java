class Decoding {

    void decode(String s, Node root) {
        StringBuilder result = new StringBuilder();
        Node current = root;

        for (int i = 0; i < s.length(); i++) {
            char bit = s.charAt(i);

            // đi xuống cây theo bit
            if (bit == '0') {
                current = current.left;
            } else { // bit == '1'
                current = current.right;
            }

            // nếu là leaf node, thêm ký tự vào kết quả
            if (current.left == null && current.right == null) {
                result.append(current.data);
                current = root; // quay lại root để tiếp tục
            }
        }

        // in kết quả giải mã
        System.out.println(result.toString());
    }
}
