import React, { useState } from 'react';
import UserService from '../services/UserService';

const userService = new UserService();

const Login = () => {
    const [form, setForm] = useState<any>([]);

    const handleSubmit = async (event:any) => {
        event.preventDefault();

        const response = await userService.login(form);
    }

    const handleChange = (event:any) => {
        console.log(event.target.value);
        setForm({...form, [event.target.name]: event.target.value})
        console.log(form);
    }

    return ( 
        <div>
            <div>
                <div>
                    <p>Username:</p>
                    <input 
                        type='text' 
                        name='username'
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <p>Password:</p>
                    <input 
                        type='password' 
                        name='password'
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <button
                        onClick={handleSubmit}
                    >
                        Login
                    </button>
                </div>
            </div>
        </div>
     );
}
 
export default Login;