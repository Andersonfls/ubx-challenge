import React, { Component } from 'react';
import '../Css/App.css';
import $ from 'jquery';
import MovieRow from '../Components/MovieRow';
import AppNavbar from '../Components/AppNavbar';
import Form from 'react-bootstrap/Form';

class Discover extends Component {
    constructor(props) {
        super(props)
        this.state = {}
        this.performSearch("28")
    }

    performSearch(searchTerm) {
        console.log("Perform search using moviedb")
        const urlString = "https://api.themoviedb.org/3/discover/movie?api_key=1b5adf76a72a13bad99b8fc0c68cb085&with_genres="+searchTerm
        $.ajax({
            url: urlString,
            success: (searchResults) => {
            console.log("Fetched data successfully")
        // console.log(searchResults)
        const results = searchResults.results
        // console.log(results[0])

        var movieRows = []

        results.forEach((movie) => {
            movie.poster_src = "https://image.tmdb.org/t/p/w185" + movie.poster_path
        // console.log(movie.poster_path)
        const movieRow = <MovieRow key={movie.id} movie={movie}/>
        movieRows.push(movieRow)
    })

        this.setState({rows: movieRows})
    },
        error: (xhr, status, err) => {
            console.error("Failed to fetch data")
        }
    })
    }

    searchChangeHandler(event) {
        console.log(event.target.value)
        const boundObject = this
        const searchTerm = event.target.value
        boundObject.performSearch(searchTerm)
    }

    render() {
        return (
            <div>
            <AppNavbar/>
            <Form>
            <Form.Group controlId="exampleForm.ControlSelect1">
            <Form.Label>Search by Gender</Form.Label>
            <Form.Control className="select-discover" as="select" onChange={this.searchChangeHandler.bind(this)}>
            <option value="placeholder">Genero</option>
            <option value="12">Action</option>
            <option value="15">Crime</option>
            <option value="17">Drama</option>
            </Form.Control>
            </Form.Group>
            </Form>

            {this.state.rows}

    </div>
    );
    }
}

export default Discover;