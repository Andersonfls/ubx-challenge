import React, { Component } from 'react';
import './Css/App.css';
import Home from './Pages/Home';
import Discover from './Pages/Discover';
import Trending from './Pages/Trending';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GroupEdit from './Components/GroupEdit';

class App extends Component {
    render() {
        return (
            <Router>
            <Switch>
            <Route path='/home' exact={true} component={Home}/>
        <Route path='/trending' exact={true} component={Trending}/>
        <Route path='/discover' exact={true} component={Discover}/>
        <Route path='/movie/:id' component={GroupEdit}/>
        </Switch>
        </Router>
    )
    }
}

export default App;