import React, {Component} from 'react'
import PropTypes from 'prop-types'

class Input extends Component {
    constructor(props) {
        super(props)
        this.state = {
            value: props.value ? props.value : '',
            error: false
        }
    }

    inputChange = (event) => {
        this.setState({value: event.target.value});
    }

    render() {
        const opt = this.props.option
        switch (this.props.id) {
            case 'password':
                this.props.required = opt === 1 || opt === 2
                this.props.disabled = opt === 3 ? true : false
                break;
            case 'repeat-password':
                this.props.required = opt === 2 ? true : false
                this.props.disabled = opt === 1 || opt === 3 ? true : false
                break;
        }
        const {handleError, ...opts} = this.props
        this.handleError = handleError
        return (
            <input {...opts} value={this.state.value} onChange={this.inputChange}/>
        )
    }
}

Input.propTypes = {
    id: PropTypes.string,
    name: PropTypes.string,
    placeholder: PropTypes.string,
    type: PropTypes.string,
    value: PropTypes.string,
    handleError: PropTypes.func,
    option: PropTypes.number
}

export default Input