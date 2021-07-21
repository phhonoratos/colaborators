import React from 'react';
import Cadastro from 'pages/Cadastro';
import Login from 'pages/Login';

import { Route, Switch, BrowserRouter } from 'react-router-dom';
import Home from 'pages/Home';
import Atualizar from 'pages/Atualizar';

function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" component={Login} exact />
                <Route path="/home" component={Home} exact />
                <Route path="/cadastrar" component={Cadastro} />
                <Route path="/atualizar" component={Atualizar} />
            </Switch>
        </BrowserRouter>

    );
}

export default Routes;