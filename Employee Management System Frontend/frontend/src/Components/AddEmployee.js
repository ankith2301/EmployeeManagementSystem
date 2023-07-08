import React, { useState } from 'react'
import EmployeeService from '../Services/EmployeeService';

const AddEmployee = () => {
    const [employee, setemployee] = useState({
        id: "",
        firstName: "",
        lastName: "",
        emailId: ""
    });
    const handleChange = (e) => {
        const value = e.target.value;
        setemployee({...employee , [e.target.name]:value})
    }
    const saveEmployee = (e)=>{
        e.preventDefault(0);
        EmployeeService.saveEmployee(employee).then((response)=>{
            console.log(response);
        }).catch(error =>{
            console.log(error);
        });
    }
    return (
        <div className='flex max-w-2xl shadow border-b m-auto'>
            <div className='px-8 py-8'>
                <div className='font-thin text-2xl'>
                    <h1>Add new Employee</h1>
                </div>
                <div className='items-center justify-center h-14 w-full my-5'>
                    <label className='block text-gray-600 text-sm font-normal'>First Name</label>
                    <input type='text' name="firstName" onChange={(e) => handleChange(e)} value={employee.firstName} className='h-10 w-96 border mt-2 px-2 py-2'></input>
                </div>
                <div className='items-center justify-center h-14 w-full my-5'>
                    <label className='block text-gray-600 text-sm font-normal'>Last Name</label>
                    <input type='text' name='lastName' onChange={(e) => handleChange(e)} value={employee.lastName} className='h-10 w-96 border mt-2 px-2 py-2'></input>
                </div>
                <div className='items-center justify-center h-14 w-full my-5'>
                    <label className='block text-gray-600 text-sm font-normal'>Email</label>
                    <input type='email' name='emailId' onChange={(e) => handleChange(e)} value={employee.emailId} className='h-10 w-96 border mt-2 px-2 py-2'></input>
                </div>
                <div className='items-center justify-center h-14 w-full my-5 space-x-4 pt-3'>
                    <button onClick={saveEmployee} className='rounded text-white font-semibold bg-green-400 py-1 px-4 hover:bg-green-700 text-sm'>Save</button>
                    <button className='rounded text-white font-semibold bg-red-400 py-1 px-4 hover:bg-red-700 text-sm'>Clear</button>
                </div>
            </div>

        </div>
    )
}

export default AddEmployee