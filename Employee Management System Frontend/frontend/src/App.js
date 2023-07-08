import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import AddEmployee from './Components/AddEmployee';
import Navbar from './Components/Navbar';
import EmployeeList from './Components/EmployeeList';

function App() {
  return (
    <>
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route index element={<EmployeeList />}></Route>
        <Route path='/' element={<EmployeeList />}></Route>
        <Route path='/employeeList' element={<EmployeeList />}></Route>
        <Route path='/addEmployee' element={<AddEmployee />}></Route>
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
