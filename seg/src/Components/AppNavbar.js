import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem } from 'reactstrap';
import { Link } from 'react-router-dom';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return <Navbar color="dark" dark expand="md">
            <td>
            <img alt="app icon" width="100" src="../logo-ub.png"/>
            </td>
            <NavbarBrand className="menuItens" tag={Link} to="/home">Home</NavbarBrand>
            <NavbarBrand className="menuItens" tag={Link} to="/trending">Trending</NavbarBrand>
            <NavbarBrand className="menuItens" tag={Link} to="/discover">Discover</NavbarBrand>
            <td>
             </td>
            <NavbarToggler onClick={this.toggle}/>
        <Collapse isOpen={this.state.isOpen} navbar>
        <Nav className="ml-auto" navbar>
        <NavItem>
        </NavItem>
        <NavItem>
            </NavItem>
            </Nav>
            </Collapse>
            </Navbar>;
    }
}