import './App.css';
import Form from './Form';
import React from "react";

const inputs = [{
    id: "email",
    name: "username",
    placeholder: "E-mail",
    type: "email",
    required: true
},{
    id: "password",
    name: "password",
    placeholder: "Password",
    type: "password"
},{
    id: "repeat-password",
    name: "repeat-password",
    placeholder: "Repeat password",
    type: "password"
}]

const props = {
    className: 'account-form',
    name: 'loginForm',
    method: 'POST',
    action: '/perform_login',
    inputs: inputs
}

function App() {
    const [option, setOption] = React.useState(1)
    const params = new URLSearchParams(window.location.search)

    return (
        <div className='container'>
            <header>
                <div
                    className={'header-headings ' + (option === 1 ? 'sign-in' : (option === 2 ? 'sign-up' : 'forgot'))}>
                    <span>Sign in to your account</span>
                    <span>Create an account</span>
                    <span>Reset your password</span>
                </div>
            </header>
            <ul className='options'>
                <li className={option === 1 ? 'active' : ''} onClick={() => setOption(1)}>Sign in</li>
                <li className={option === 2 ? 'active' : ''} onClick={() => setOption(2)}>Sign up</li>
                <li className={option === 3 ? 'active' : ''} onClick={() => setOption(3)}>Forgot</li>
            </ul>
            <Form {...props} option={option} error={params.get('error')}/>
        </div>
    )
}

export default App;
