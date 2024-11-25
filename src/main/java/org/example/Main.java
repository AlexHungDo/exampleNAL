package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int countVietnameseCharacters(String inputString) {
        // Tạo một bản đồ (map) chứa các quy tắc chuyển Telex
        Map<String, String> telexMap = new HashMap<>();
        telexMap.put("aw", "ă");
        telexMap.put("aa", "â");
        telexMap.put("dd", "đ");
        telexMap.put("ee", "ê");
        telexMap.put("oo", "ô");
        telexMap.put("ow", "ơ");
        telexMap.put("w", "ư");

        int count = 0;
        int i = 0;

        // Duyệt qua chuỗi đầu vào
        while (i < inputString.length()) {
            // Kiểm tra chuỗi con 2 ký tự đầu tiên
            if (i + 1 < inputString.length() && telexMap.containsKey(inputString.substring(i, i + 2))) {
                count++; // Tăng đếm nếu tìm thấy chuỗi con trong telexMap
                i += 2; // Nếu tìm thấy, nhảy qua 2 ký tự
            }
            // Kiểm tra chuỗi con 1 ký tự nếu không phải chuỗi 2 ký tự
            else if (telexMap.containsKey(inputString.substring(i, i + 1))) {
                count++; // Tăng đếm nếu tìm thấy chuỗi con 1 ký tự trong telexMap
                i++; // Nếu tìm thấy, nhảy qua 1 ký tự
            } else {
                i++; // Nếu không phải, tiếp tục kiểm tra ký tự tiếp theo
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String inputString = "hwfdawhwhcoomddfgwdc";
        int result = countVietnameseCharacters(inputString);
        System.out.println("Output: " + result); // Kết quả đếm các chữ cái có dấu
    }
}
