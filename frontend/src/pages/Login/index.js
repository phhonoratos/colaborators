import React from 'react'
import axios from 'axios'
import './styles.css'
import LocalStorageService from 'app/service/localStorageService'
import { BASE_URL } from 'app/utils/requests'

class Login extends React.Component {

    state = {
        email: "",
        senha: "",
    }

    entrar = () => {
        axios.post(`${BASE_URL}/login`, {
            email: this.state.email,
            senha: this.state.senha
        }).then( response => {
            LocalStorageService.addItem('email', this.state.email)
            this.props.history.push('/home')
        }).catch( erro => {
            alert('Email ou senha inválidos')
            console.log(erro.response)
        })

    }

    Cadastrar = () => {
        this.props.history.push('/cadastrar')
    }

    render() {
        return (
            <div className="container">
                <h3 className="mt-3">Olá Visitante!</h3>
                <div className="card">
                    <div className="card-header">
                        <h5>Login</h5>
                    </div>
                    <div className="card-body">
                        <div className="form-group mt-4">
                            <input type="text" 
                                value={this.state.email}
                                onChange={e => this.setState({email: e.target.value})}
                                className="form-control" 
                                placeholder="Digite o CPF ou o PIS" />
                        </div>
                        <div className="form-group mt-4">
                            <input type="password" 
                                value={this.state.senha}
                                onChange={e => this.setState({senha: e.target.value})}
                                className="form-control" 
                                placeholder="Password" />
                        </div>
                        <div className="botoes">
                            <button className="btn btn-success" onClick={this.entrar}>Entrar</button>
                            <h5 className="mt-4">OU</h5>
                            <button className="btn btn-danger" onClick={this.Cadastrar}>Cadastre-se</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;