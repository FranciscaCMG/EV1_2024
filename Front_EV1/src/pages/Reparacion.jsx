import { Box, Button, Grid, MenuItem, TextField } from "@mui/material";
import { useState } from "react";
import Checkbox from '@mui/material/Checkbox';
import OutboxIcon from '@mui/icons-material/Outbox';
import CalculateIcon from '@mui/icons-material/Calculate';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import axios from "axios";



export default function Reparacion() {

    const [patente, setPatente] = useState("");
    const [error, setError] = useState({
        error: false,
        message: '',
    });





    return (
        <>
            <h1 style={{ textAlign: 'center' }}>Registro de Reparaciones</h1>

            <Box
                component="form"


                sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    '& > :not(style)': { m: 1 },
                }}
                noValidate
                autoComplete="off"
            >
                <Grid container spacing={2}>
                    <Grid item xs={6}>
                        <h4>Patente</h4>
                        <TextField
                            id="patente"
                            label="Ingrese la patente del vehículo"
                            variant="outlined"
                            fullWidth

                            required

                            value={patente}
                            onChange={(e) => setPatente(e.target.value)}
                        />
                    </Grid>
                    <Grid item xs={6}>
                        <Button
                            type="submit"
                            color="warning"
                            variant="outlined"
                            sx={{ mt: 3, mb: 2, marginLeft: 0, marginTop: 9 }}
                        >
                            Revisar Patente
                        </Button>
                    </Grid>
                </Grid>


                <Grid container spacing={2}>

                    <Grid item xs={6}>
                        <h4>Fecha Ingreso</h4>
                        <TextField

                            id="fechaingreso"
                            label="Ingrese la fecha de ingreso"
                            fullWidth
                            required

                        > </TextField>
                    </Grid>
                    <Grid item xs={6}>

                        <h4>Tipo de Reparación</h4>
                        <FormControl component="fieldset">
                            <FormGroup aria-label="position" row>
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="1"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="2"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="3"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="4"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="5"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="6"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="7"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="8"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="9"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="10"
                                    labelPlacement="top"
                                />
                                <FormControlLabel
                                    value="top"
                                    control={<Checkbox />}
                                    label="11"
                                    labelPlacement="top"
                                />

                            </FormGroup>
                        </FormControl>
                    </Grid>

                </Grid>


                <Grid container spacing={2} sx={{ display: 'flex', justifyContent: 'center' }}>
                    <Grid item>
                        <Button
                            startIcon={<CalculateIcon />}
                            type="submit"
                            variant="outlined"

                            sx={{ mt: 3, mb: 2, marginLeft: 0, marginTop: 6, width: '20rem' }}
                        >
                            Calcular Costo
                        </Button>
                    </Grid>
                    <Grid item>
                        <Button
                            startIcon={<OutboxIcon />}
                            type="submit"
                            variant="contained"

                            sx={{ mt: 3, mb: 2, marginLeft: 0, marginTop: 6, width: '20rem' }}
                        >
                            Ingresar Reparación
                        </Button>
                    </Grid>
                </Grid>

            </Box>
        </>
    );
}


