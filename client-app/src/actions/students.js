import axios from "axios";

export const getAllStudents =  async () => {
    try {
        const res = await  axios.get('http://localhost:8080/api/student');
        console.log("Student Response", res.data)
        return res.data;
    } catch (error) {
        console.log("Error!", error)
    }
}

export const deleteStudent = async (id) => {
    try {
        await axios.delete(`http://localhost:8080/api/student/${id}`);
    } catch (error) {
        console.log("Error!", error)
    }
    
  };

export const addStudent = async (student) => {
    try {
        const res = await axios.post('http://localhost:8080/api/student', student);
        return res;
    } catch (error) {
        console.log("Error!", error)
    }
}