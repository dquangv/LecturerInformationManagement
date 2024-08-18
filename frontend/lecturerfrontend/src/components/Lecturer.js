import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Snackbar } from '@mui/material';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import Button from '@mui/material/Button';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import { styled } from '@mui/material/styles';
import MuiAlert from '@mui/material/Alert';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import dayjs from 'dayjs';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
// import Stack from '@mui/material/Stack';


const VisuallyHiddenInput = styled('input')({
    clip: 'rect(0 0 0 0)',
    clipPath: 'inset(50%)',
    height: 1,
    overflow: 'hidden',
    position: 'absolute',
    bottom: 0,
    left: 0,
    whiteSpace: 'nowrap',
    width: 1,
});

const Alert = React.forwardRef(function Alert(props, ref) {
    return <MuiAlert elevation={6} ref={ref} variant="filled" {...props} />;
});

export default function LecturerForm({ searchTerm }) {
    const [lecturer, setLecturer] = React.useState({
        idLecturer: '',
        firstName: '',
        lastName: '',
        lecturerType: '',
        educationLevel: '',
        lecturerImage: '',
        baseSalary: '',
        startDate: null,
        email: '',
        phoneNumber: '',
        department: ''
    });

    const [lecturers, setLecturers] = React.useState([]);  
    const [fileName, setFileName] = React.useState('');
    const [openSnackbar, setOpenSnackbar] = React.useState(false);
    const [selectedLecturerId, setSelectedLecturerId] = React.useState(null);
    const [avatarUrl, setAvatarUrl] = React.useState('');
    const [snackbarMessage, setSnackbarMessage] = React.useState('');
    const [selectedEducationLevel, setSelectedEducationLevel] = React.useState('');

    const handleRowClick = (id) => {
        setSelectedLecturerId(id);
        fetchLecturerById(id);
    };

    const fetchLecturerById = (id) => {
        fetch(`http://localhost:8080/api/v1/lecturers/${id}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setLecturer({
                    id: data.id,
                    idLecturer: data.idLecturer,
                    firstName: data.firstName,
                    lastName: data.lastName,
                    lecturerType: data.lecturerType,
                    educationLevel: data.educationLevel,
                    lecturerImage: data.lecturerImage,
                    baseSalary: data.baseSalary.toString(),
                    startDate: data.startDate ? dayjs(data.startDate) : null,
                    email: data.email,
                    phoneNumber: data.phoneNumber,
                    department: data.department
                });

                const imageUrl = data.lecturerImage
                    ? `http://localhost:8080/img/${data.lecturerImage}` 
                    : 'http://localhost:8080/img/default_user_avatar.jpg'; 


                console.log(data.lecturerImage);
                console.log(imageUrl);
                setAvatarUrl(imageUrl);

            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
    };



    // const fetchLecturers = () => {
    //     fetch('http://localhost:8080/api/v1/lecturers/getAll')
    //         .then(response => {
    //             if (!response.ok) {
    //                 throw new Error('Network response was not ok');
    //             }
    //             return response.json();
    //         })
    //         .then(data => {
    //             setLecturers(data);  // Set the fetched lecturers to state
    //         })
    //         .catch(error => {
    //             console.error('There was a problem with the fetch operation:', error);
    //         });
    // };

    const fetchLecturers = (educationLevel) => {
        const url = educationLevel
            ? `http://localhost:8080/api/v1/lecturers/filter?educationLevel=${educationLevel}`
            : 'http://localhost:8080/api/v1/lecturers/getAll';

        fetch(url)
            .then(response => response.json())
            .then(data => {
                setLecturers(data);
            })
            .catch(error => {
                console.error('Error fetching lecturers:', error);
            });
    };

    React.useEffect(() => {
        const fetchLecturers = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/v1/lecturers/filterAndSearch?educationLevel=${selectedEducationLevel}&searchTerm=${searchTerm}`);
                const data = await response.json();
                setLecturers(data);
            } catch (error) {
                console.error('Error fetching lecturers:', error);
            }
        };

        fetchLecturers();
    }, [selectedEducationLevel, searchTerm]);

    React.useEffect(() => {
        fetchLecturers(selectedEducationLevel);
    }, [selectedEducationLevel]);

    const handleEducationLevelChange = (event) => {
        setSelectedEducationLevel(event.target.value);
    };

    const handleChange = (event) => {
        setLecturer({
            ...lecturer,
            [event.target.name]: event.target.value
        });
    };

    // const handleFileChange = (event) => {
    //     const file = event.target.files[0];
    //     setFileName(file.name);
    //     setLecturer({
    //         ...lecturer,
    //         lecturerImage: file.name
    //     });

    //     // Tạo URL cho ảnh đã chọn
    //     const imageUrl = URL.createObjectURL(file);
    //     setAvatarUrl(imageUrl);
    // };

    const handleFileChange = (event) => {
        const file = event.target.files[0];
        setFileName(file.name);
        setLecturer({
            ...lecturer,
            lecturerImage: file  
        });

        const imageUrl = URL.createObjectURL(file);
        setAvatarUrl(imageUrl);
    };


    // const handleUpdate = () => {
    //     const data = {
    //         idLecturer: lecturer.idLecturer,
    //         firstName: lecturer.firstName,
    //         lastName: lecturer.lastName,
    //         lecturerType: lecturer.lecturerType,
    //         educationLevel: lecturer.educationLevel,
    //         lecturerImage: lecturer.lecturerImage || null,
    //         baseSalary: parseFloat(lecturer.baseSalary),
    //         startDate: lecturer.startDate ? lecturer.startDate.format('YYYY-MM-DD') : null,
    //         email: lecturer.email,
    //         phoneNumber: lecturer.phoneNumber,
    //         department: lecturer.department
    //     };

    //     console.log(lecturer);
    //     console.log(lecturer.id);

    //     fetch(`http://localhost:8080/api/v1/lecturers/update/${lecturer.id}`, {
    //         method: 'PUT',
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(data),
    //     })
    //         .then(response => response.json())
    //         .then(data => {
    //             console.log('Lecturer updated successfully!', data);
    //             fetchLecturers();  // Cập nhật lại danh sách giảng viên
    //             resetForm();  // Reset form về trạng thái ban đầu
    //             setSnackbarMessage('Cập nhật giảng viên thành công!');
    //             setOpenSnackbar(true);
    //         })
    //         .catch(error => {
    //             console.error('There was a problem with the update operation:', error);
    //         });
    // };

    const handleUpdate = () => {
        const formData = new FormData();

        formData.append('idLecturer', lecturer.idLecturer);
        formData.append('firstName', lecturer.firstName);
        formData.append('lastName', lecturer.lastName);
        formData.append('lecturerType', lecturer.lecturerType);
        formData.append('educationLevel', lecturer.educationLevel);
        formData.append('baseSalary', parseFloat(lecturer.baseSalary));
        formData.append('startDate', lecturer.startDate ? lecturer.startDate.format('YYYY-MM-DD') : null);
        formData.append('email', lecturer.email);
        formData.append('phoneNumber', lecturer.phoneNumber);
        formData.append('department', lecturer.department);

        
        if (lecturer.lecturerImage && lecturer.lecturerImage instanceof File) {
            formData.append('file', lecturer.lecturerImage);  
        }

        fetch(`http://localhost:8080/api/v1/lecturers/update/${lecturer.id}`, {
            method: 'PUT',
            body: formData,  
        })
            .then(response => response.json())
            .then(data => {
                console.log('Lecturer updated successfully!', data);
                fetchLecturers(); 
                resetForm();  
                setSnackbarMessage('Cập nhật giảng viên thành công!');
                setOpenSnackbar(true);
            })
            .catch(error => {
                console.error('There was a problem with the update operation:', error);
            });
    };


    const resetForm = () => {
        setLecturer({
            idLecturer: '',
            firstName: '',
            lastName: '',
            lecturerType: '',
            educationLevel: '',
            lecturerImage: '',
            baseSalary: '',
            startDate: null,
            email: '',
            phoneNumber: '',
            department: ''
        });
        setFileName('');
        setAvatarUrl(''); 
    };

    <Button variant="contained" onClick={resetForm}>Làm mới</Button>


    // const handleAdd = () => {
    //     const data = {
    //         idLecturer: lecturer.idLecturer,
    //         firstName: lecturer.firstName,
    //         lastName: lecturer.lastName,
    //         lecturerType: lecturer.lecturerType,
    //         educationLevel: lecturer.educationLevel,
    //         lecturerImage: lecturer.lecturerImage || null,
    //         baseSalary: parseFloat(lecturer.baseSalary),
    //         startDate: lecturer.startDate ? lecturer.startDate.format('YYYY-MM-DD') : null,
    //         email: lecturer.email,
    //         phoneNumber: lecturer.phoneNumber,
    //         department: lecturer.department
    //     };

    //     fetch('http://localhost:8080/api/v1/lecturers/add', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify(data),
    //     })
    //         .then(response => {
    //             const contentType = response.headers.get('content-type');
    //             if (contentType && contentType.includes('application/json')) {
    //                 return response.json();
    //             } else {
    //                 return response.text();  // If not JSON, treat it as text
    //             }
    //         })
    //         .then(data => {
    //             if (typeof data === 'string') {
    //                 console.log('Server response:', data); // Log the plain text response
    //             } else {
    //                 console.log('Lecturer added successfully!', data); // Log JSON response if available
    //             }
    //             setSnackbarMessage('Thêm giảng viên thành công!');
    //             setOpenSnackbar(true);  // Show success message
    //             // Reload lecturers list after adding a new one
    //             fetchLecturers();
    //             resetForm();
    //         })
    //         .catch(error => {
    //             console.error('There was a problem with the fetch operation:', error);
    //         });
    // };

    const handleAdd = () => {
        const formData = new FormData();

        
        formData.append('idLecturer', lecturer.idLecturer);
        formData.append('firstName', lecturer.firstName);
        formData.append('lastName', lecturer.lastName);
        formData.append('lecturerType', lecturer.lecturerType);
        formData.append('educationLevel', lecturer.educationLevel);
        formData.append('baseSalary', parseFloat(lecturer.baseSalary));
        formData.append('startDate', lecturer.startDate ? lecturer.startDate.format('YYYY-MM-DD') : null);
        formData.append('email', lecturer.email);
        formData.append('phoneNumber', lecturer.phoneNumber);
        formData.append('department', lecturer.department);

        
        if (lecturer.lecturerImage) {
            formData.append('file', lecturer.lecturerImage); 
        }

        fetch('http://localhost:8080/api/v1/lecturers/add', {
            method: 'POST',
            body: formData 
        })
            .then(response => {
                const contentType = response.headers.get('content-type');
                if (contentType && contentType.includes('application/json')) {
                    return response.json();
                } else {
                    return response.text();  
                }
            })
            .then(data => {
                if (typeof data === 'string') {
                    console.log('Server response:', data); 
                } else {
                    console.log('Lecturer added successfully!', data); 
                }
                setSnackbarMessage('Thêm giảng viên thành công!');
                setOpenSnackbar(true);
                fetchLecturers();  
                resetForm();
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
    };


    // const handleCloseSnackbar = (event, reason) => {
    //     if (reason === 'clickaway') {
    //         return;
    //     }
    //     setOpenSnackbar(false);
    // };

    return (
        <Container style={{ marginTop: '64px' }}>
            <Paper elevation={3} style={{ padding: '50px 20px', width: 600, margin: "20px auto" }}>
                <Box ml={2} display="flex" flexDirection="column" alignItems="center">
                    <Avatar
                        src={avatarUrl}
                        alt="Lecturer Avatar"
                        sx={{ width: 100, height: 100, mb: 2 }}
                    />
                    <VisuallyHiddenInput
                        accept="image/*"
                        id="upload-file"
                        type="file"
                        onChange={handleFileChange}
                    />
                    <label htmlFor="upload-file">
                        <Button variant="contained" component="span" startIcon={<CloudUploadIcon />}>
                            Hình ảnh
                        </Button>
                    </label>
                    {fileName && (
                        <Typography variant="caption" style={{ marginTop: '10px' }}>
                            File uploaded: {fileName}
                        </Typography>
                    )}
                </Box>
                <Box
                    component="form"
                    sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', '& > :not(style)': { m: 1, width: '80%' } }}
                    noValidate
                    autoComplete="off"
                >
                    <TextField
                        name="idLecturer"
                        label="Mã giảng viên"
                        variant="standard"
                        value={lecturer.idLecturer}
                        onChange={handleChange}
                    />
                    <TextField
                        name="lastName"
                        label="Họ lót"
                        variant="standard"
                        value={lecturer.lastName}
                        onChange={handleChange}
                    />
                    <TextField
                        name="firstName"
                        label="Tên"
                        variant="standard"
                        value={lecturer.firstName}
                        onChange={handleChange}
                    />
                    <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
                        <InputLabel id="lecturer-type-label">Loại giảng viên</InputLabel>
                        <Select
                            labelId="lecturer-type-label"
                            name="lecturerType"
                            value={lecturer.lecturerType}
                            onChange={handleChange}
                            label="Lecturer_Type"
                        >
                            <MenuItem value="FULL_TIME">FULL_TIME</MenuItem>
                            <MenuItem value="PART_TIME">PART_TIME</MenuItem>
                        </Select>
                    </FormControl>
                    <TextField
                        name="baseSalary"
                        label="Lương cơ bản"
                        variant="standard"
                        type="number"
                        value={lecturer.baseSalary}
                        onChange={handleChange}
                    />
                    <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
                        <InputLabel id="education-level-label">Trình độ học vấn</InputLabel>
                        <Select
                            labelId="education-level-label"
                            name="educationLevel"
                            value={lecturer.educationLevel}
                            onChange={handleChange}
                            label="Education_Level"
                        >
                            <MenuItem value="ASSOCIATE">Cử nhân Cao đẳng</MenuItem>
                            <MenuItem value="BACHELOR">Cử nhân Đại học</MenuItem>
                            <MenuItem value="MASTER">Thạc sỹ</MenuItem>
                            <MenuItem value="DOCTORATE">Tiến sỹ</MenuItem>
                        </Select>
                    </FormControl>
                    <TextField
                        name="email"
                        label="Email"
                        variant="standard"
                        value={lecturer.email}
                        onChange={handleChange}
                    />
                    <TextField
                        name="phoneNumber"
                        label="Số điện thoại"
                        variant="standard"
                        type="number"
                        value={lecturer.phoneNumber}
                        onChange={handleChange}
                    />
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DatePicker
                            value={lecturer.startDate}
                            onChange={(newValue) => setLecturer({ ...lecturer, startDate: newValue })}
                            renderInput={(params) => <TextField {...params} variant="standard" />}
                        />
                    </LocalizationProvider>
                    <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
                        <InputLabel id="department-label">Bộ môn</InputLabel>
                        <Select
                            labelId="department-label"
                            name="department"
                            value={lecturer.department}
                            onChange={handleChange}
                            label="department"
                        >
                            <MenuItem value="INFORMATION_TECHNOLOGY">Công nghệ thông tin</MenuItem>
                            <MenuItem value="SOFTWARE_APPLICATION">Ứng dụng phần mềm</MenuItem>
                            <MenuItem value="SOFTWARE_DEVELOPMENT">Phát triển phần mềm</MenuItem>
                        </Select>
                    </FormControl>
                    <VisuallyHiddenInput
                        accept="image/*"
                        id="upload-file"
                        multiple
                        type="file"
                        onChange={handleFileChange}
                    />
                </Box>

                <Box ml={1} mt={2} display="flex" justifyContent="center" alignItems="center">
                    <Button variant="contained" onClick={handleAdd} style={{ flex: 1, margin: '0 8px' }}>
                        Thêm
                    </Button>
                    <Button variant="contained" onClick={handleUpdate} style={{ flex: 1, margin: '0 8px' }}>
                        Cập nhật
                    </Button>
                    <Button variant="contained" onClick={resetForm} style={{ flex: 1, margin: '0 8px' }}>
                        Làm mới
                    </Button>
                </Box>


                <Snackbar open={openSnackbar} autoHideDuration={6000} onClose={() => setOpenSnackbar(false)}>
                    <Alert onClose={() => setOpenSnackbar(false)} severity="success" sx={{ width: '100%' }}>
                        {snackbarMessage}
                    </Alert>
                </Snackbar>
            </Paper>
            {/* Table to display lecturers */}
            <Paper elevation={3} style={{ padding: '20px', margin: '20px auto', maxWidth: 1000 }}>
                <h2>Danh sách giảng viên</h2>
                <Box mb={2}>
                    <FormControl variant="standard" fullWidth>
                        <InputLabel id="education-level-select-label">Trình độ học vấn</InputLabel>
                        <Select
                            labelId="education-level-select-label"
                            value={selectedEducationLevel}
                            onChange={handleEducationLevelChange}
                            label="Trình độ học vấn"
                        >
                            <MenuItem value="">Tất cả</MenuItem>
                            <MenuItem value="ASSOCIATE">Cử nhân Cao đẳng</MenuItem>
                            <MenuItem value="BACHELOR">Cử nhân Đại học</MenuItem>
                            <MenuItem value="MASTER">Thạc sỹ</MenuItem>
                            <MenuItem value="DOCTORATE">Tiến sỹ</MenuItem>
                        </Select>
                    </FormControl>
                </Box>

                <Box sx={{ overflowX: 'auto' }}>
                    <TableContainer>
                        <Table style={{ minWidth: 1200 }}>
                            <TableHead>
                                <TableRow>
                                    <TableCell>Mã giảng viên</TableCell>
                                    <TableCell>Họ lót</TableCell>
                                    <TableCell>Tên</TableCell>
                                    <TableCell>Loại giảng viên</TableCell>
                                    <TableCell>Trình độ học vấn</TableCell>
                                    <TableCell>Hình ảnh</TableCell>
                                    <TableCell>Lương cơ bản</TableCell>
                                    <TableCell>Ngày bắt đầu làm việc</TableCell>
                                    <TableCell>Email</TableCell>
                                    <TableCell>Số điện thoại</TableCell>
                                    <TableCell>Bộ môn</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {lecturers.map((lecturer) => (
                                    <TableRow
                                        key={lecturer.id}
                                        onClick={() => handleRowClick(lecturer.id)}
                                        style={{ cursor: 'pointer' }}
                                        hover
                                    >
                                        <TableCell>{lecturer.idLecturer}</TableCell>
                                        <TableCell>{lecturer.lastName}</TableCell>
                                        <TableCell>{lecturer.firstName}</TableCell>
                                        <TableCell>{lecturer.lecturerType}</TableCell>
                                        <TableCell>{lecturer.educationLevel}</TableCell>
                                        <TableCell>{lecturer.lecturerImage}</TableCell>
                                        <TableCell>{lecturer.baseSalary}</TableCell>
                                        <TableCell>{lecturer.startDate}</TableCell>
                                        <TableCell>{lecturer.email}</TableCell>
                                        <TableCell>{lecturer.phoneNumber}</TableCell>
                                        <TableCell>{lecturer.department}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Box>
            </Paper>

        </Container>
    );
}
