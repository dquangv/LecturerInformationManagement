CREATE DATABASE LecturerInformationManagement;

use LecturerInformationManagement;

CREATE TABLE Lecturer (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_lecturer VARCHAR(50),
    first_name VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL, 
    last_name VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL, 
    lecturer_type ENUM('Full-time', 'Part-time') NOT NULL,
    education_level ENUM('Cử nhân Cao đẳng', 'Cử nhân Đại học', 'Thạc sỹ', 'Tiến sỹ') NOT NULL,
    lecturer_image VARCHAR(255),
    base_salary DECIMAL(10, 2) NOT NULL,
    start_date DATE NOT NULL, 
    email VARCHAR(100),
    phone_number VARCHAR(20),
    department enum("Công nghệ thông tin", "Ứng dụng phần mềm", "Phát triển phần mềm") NOT NULL
);

INSERT INTO Lecturer (id_lecturer, first_name, last_name, lecturer_type, education_level, lecturer_image, base_salary, start_date, email, phone_number, department)
VALUES 
('liemht6', 'Hà Thanh', 'Liêm', 1, 2, null, 20000000, '2020-01-01', 'liemht6@fpt.edu.vn', '0101010101', 1),
('binhtq7', 'Trần Quang', 'Bình', 0, 2, null, 25000000, '2018-01-01', 'binhtq7@fpt.edu.vn', '0202020202', 2);