import React from 'react';
import TextField from '@material-ui/core/TextField';

export const RenderTextField = props => (
  <TextField
    hintText={props.label}
    floatingLabelText={props.label}
    errorText={props.touched && props.error}
    onChange={() => props.handleChange()}
    {...props}
  />
);

export const RenderMultilineTextField = props => (
  <TextField
    hintText={props.label}
    id="multiline-flexible"
    multiline
    rowsMax="4"
    floatingLabelText={props.label}
    errorText={props.touched && props.error}
    onChange={() => props.handleChange()}
    {...props}
  />
);

export const RenderPassword = props => (
  <TextField
    id="password-input"
    type="password"
    autoComplete="current-password"
    hintText={props.label}
    floatingLabelText={props.label}
    errorText={props.touched && props.error}
    onChange={() => props.handleChange()}
    {...props}
  />
);
