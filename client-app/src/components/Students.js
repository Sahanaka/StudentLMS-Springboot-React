import React, { useEffect, useState } from "react";
import {
  Row,
  Col,
  Container,
  Button,
  Form,
  Alert,
  Navbar,
  Nav,
  Table
} from "react-bootstrap";

import axios from "axios";

const Students = () => {
  const [students, setStudents] = useState([]);

  const [studentDetails, setStudentDetails] = useState({
    name: "",
    email: "",
    age: "",
  });

  const onValueChange = (e) => {
    setStudentDetails({ ...studentDetails, [e.target.name]: e.target.value });
  };

  const onSubmitData = async (e) => {
    e.preventDefault();
    console.log("called", studentDetails);
    try {
      await axios.post("http://localhost:8080/api/student", studentDetails);
    } catch (error) {
      Alert(error)
    }
    axios
      .get("http://localhost:8080/api/student")
      .then(function (response) {
        setStudents(response.data);
        console.log(response);
      })
      .catch(function (error) {
        Alert(error);
      });
  };

  const deleteStudent = async (id) => {
    await axios.delete(`http://localhost:8080/api/student/${id}`);
    axios
      .get("http://localhost:8080/api/student")
      .then(function (response) {
        setStudents(response.data);
        console.log(response);
      })
      .catch(function (error) {
        Alert(error);
      });
  };

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/student")
      .then(function (response) {
        setStudents(response.data);
        console.log(response);
      })
      .catch(function (error) {
        Alert(error);
      });
  }, []);

  return (
    <div>
      <Navbar bg="dark" variant="dark">
    <Container>
      <Navbar.Brand href="#home">
      Student Learning Management System
      </Navbar.Brand>
    </Container>
  </Navbar>

      <div class="container">
        <div class="row">
          <div class="col"><Form onSubmit={onSubmitData}>
            <Form.Group className="mb-3">
              <Form.Label>Enter the Name</Form.Label>
              <Form.Control
                placeholder="Name"
                value={studentDetails.name}
                type="name"
                required
                onChange={onValueChange}
                name="name"
              />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Enter the Email</Form.Label>
              <Form.Control
                placeholder="Email"
                value={studentDetails.email}
                type="email"
                required
                onChange={onValueChange}
                name="email"
              />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Enter the Age</Form.Label>
              <Form.Control
                placeholder="Age"
                value={studentDetails.age}
                type="age"
                onChange={onValueChange}
                name="age"
              />
            </Form.Group>

            <Row>
              <Col className="mb-1">
                <Button variant="primary" type="submit">
                  Submit
                </Button>
              </Col>
            </Row>
          </Form>
          </div>
          
          <div class="col">
            <hr/>
            {students.map((student) => {

            return(<Table striped bordered hover variant="dark">
            <thead>
              <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{student.name}</td>
                <td>{student.email}</td>
                <td>{student.age}</td>
                <td><Button
                        onClick={() => {
                          deleteStudent(student.id);
                        }}
                        variant="outline-danger"
                      >
                        Delete
                      </Button></td>
              </tr>
              
            </tbody>
          </Table>);
            
          })}
          </div>
          <div class="w-100"></div>
          
        </div>
      </div>

      
    </div>
  );
};

export default Students;
