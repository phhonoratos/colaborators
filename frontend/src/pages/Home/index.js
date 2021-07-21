import LocalStorageService from 'app/service/localStorageService';
import axios from 'axios';
import React from 'react'
import Cookies from 'js-cookie'

class Home extends React.Component {

    state = {
        nome: ''
    }

    atualizar = () => {
        this.props.history.push('/atualizar')
    }

    logout = () => {
        this.props.history.push('/')
        Cookies.remove('_usuario_logado')
    }

    componentDidMount() {
        const emailAutenticado = LocalStorageService.obterItem('email')
        axios.post('http://localhost:8080/colaborators/acessar', {
            email: emailAutenticado
        }).then( response => {
            Cookies.set('_usuario_logado', `${JSON.stringify(response.data)}`, {expires: 1})
            axios.get(`http://localhost:8080/colaborators/${response.data.id}`)
                .then(response => {
                    this.setState({nome: response.data.nome})
                }).catch(erro => {
                    this.setState({msgErro: erro.response})
                    console.log('errooooo', erro.response)
                })
        }).catch( erro => {
            this.setState({msgErro: erro.response})
        })
    }

    render(){
        return (
            <div>
                <h1>Olá {this.state.nome}!</h1>
                <div className="d-flex flex-column">
                    <button className="btn btn-primary" onClick={this.atualizar}>Atualizar Dados</button>                
                    <button className="btn btn-danger" onClick={this.logout}>Logout</button>
                </div>
            </div>
        )
    }
}

export default Home;