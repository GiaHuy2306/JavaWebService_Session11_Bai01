# Phần 1 - Phân tích logic

## 1. Lỗi tính phí cân nặng

Trong code đang dùng:

Math.floor(weightKg - 1)


Ví dụ:

1.5kg

thì:

Math.floor(0.5) = 0

=> hệ thống không cộng thêm 10.000 VND cho phần 0.5kg.

Trong khi yêu cầu nghiệp vụ nói:

Mỗi kg tiếp theo hoặc phần lẻ đều phải tính thêm phí.

Nên cần dùng:

Math.ceil()

để làm tròn lên.

## 2. Lỗi tính phí khoảng cách tại mốc 50km

Code hiện tại:

distanceKm * 4000

khi khoảng cách >= 50km.

Ví dụ:

50km

thì phí được tính:

50 * 4000 = 200000

Nhưng theo nghiệp vụ:

từ 10km đến dưới 50km:
5000/km
từ 50km trở lên:
chỉ phần vượt 50km mới tính 4000/km

Nghĩa là:

50km đầu tiên vẫn phải tính theo 5000/km

Do đó logic hiện tại làm cho phí bị thấp hơn thực tế ở mốc 50km trở lên.

## Kết luận

Hệ thống bị sai do:

dùng Math.floor() thay vì Math.ceil() cho cân nặng số lẻ
tính sai phí khoảng cách khi >= 50km