import React, { Component } from 'react';
import '../Css/App.css';
import Carousel from 'react-bootstrap/Carousel';
import AppNavbar from '../Components/AppNavbar';

class Trending extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }

    render() {
        return (
            <div>
            <AppNavbar/>
            <Carousel className="img-banner-img">
            <Carousel.Item>
            <img  className="d-block w-100" src="https://image.tmdb.org/t/p/w185/qvktm0BHcnmDpul4Hz01GIazWPr.jpg" alt="First slide" />
            <Carousel.Caption>
            <h3>First The Terminator</h3>
        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
        </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
        <img className="d-block w-100" src="https://image.tmdb.org/t/p/w185/oZRVDpNtmHk8M1VYy1aeOWUXgbC.jpg" alt="second slide" />

            <Carousel.Caption>
            <h3>Second Terminator Genesys</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
        <img className="d-block w-100" src="https://image.tmdb.org/t/p/w185/gw6JhlekZgtKUFlDTezq3j5JEPK.jpg" alt="Third slide" />

            <Carousel.Caption>
            <h3>Terminator Salvation</h3>
        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
        </Carousel.Caption>
        </Carousel.Item>
        </Carousel>

    </div>
    );
    }
}

export default Trending;