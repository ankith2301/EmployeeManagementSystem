import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import EmployeeService from '../Services/EmployeeService';
import Employee from './Employee';

const EmployeeList = () => {
    const navigate = useNavigate();
    const [employees, setemployees] = useState(null);
    const [loading, setloading] = useState(true);
    useEffect(() => {
        const fetchData = async () => {
            setloading(true);
            try {
                const response = await EmployeeService.getEmployees();
                setemployees(response.data);
            } catch (error) {
                console.log(error);
            }
            setloading(false);
        };
        fetchData();
    }, []);
    return (
        <div className='container mx-10 my-8'>
            <div className='h-12'>
                <button
                    onClick={() => navigate("/addEmployee")}
                    className='rounded bg-slate-600 text-white px-6 py-2 font-semibold'>
                    Add Employee
                </button>
            </div>
            <div className='flex shadow border-b'>
                <table className='min-w-full'>
                    <thead className='bg-gray-50'>
                        <tr>
                            <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>First Name</th>
                            <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Last Name</th>
                            <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Emial ID</th>
                            <th className='text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6'>Actions</th>
                        </tr>
                    </thead>
                    {!loading && (
                        <tbody className='bg-white'>
                            {employees.map((employee) => (
                                <Employee employee={employee} key={employee.id}></Employee>
                            ))}
                        </tbody>
                    )}
                </table>
            </div>
        </div>
    )
}

export default EmployeeList