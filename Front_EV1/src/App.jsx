import { Button, Container, Typography } from "@mui/material";
import { Box } from '@mui/system';
import AccessAlarmIcon from '@mui/icons-material/AccessAlarm';
import Grid from '@mui/material/Grid';
import VehiculoCard from "./components/VehiculoCard";

export default function App() {
  return (
    <Container sx={{ border: 3, boxShadow: 3, pb: 2 }}> {/* Cambiar el ancho a "xs" maxWidth="xs"*/}
      <VehiculoCard />
      <Grid container spacing={2}>
        <Grid
          item
          xs={12}
          sm={6}
          md={4}>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis corporis, mollitia in nisi repellat aut, distinctio sapiente sint saepe consequuntur, aliquam repudiandae blanditiis repellendus magnam numquam facilis iure velit excepturi.
          </p>
        </Grid>
        <Grid
          item
          xs={12}
          sm={6}
          md={4}>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis corporis, mollitia in nisi repellat aut, distinctio sapiente sint saepe consequuntur, aliquam repudiandae blanditiis repellendus magnam numquam facilis iure velit excepturi.
          </p>
        </Grid>
      </Grid>


      <h1>Hello, world!</h1>

      <Typography variant="h1" component="h2" >Título 1</Typography> {/* Cambiar el elemnto semántico predeterminado usando component*/}
      <Typography variant="body1" textAlign="center" >Título 2</Typography>

      <Button
        variant="contained"
        color="error"
        startIcon={<AccessAlarmIcon />}
      >Levántate Cartitaaa!</Button>
      <Button
        variant="contained"
        color="error"
        endIcon={<AccessAlarmIcon />}
      >Acuéstate Cartita!</Button>

      <Box
        sx={{
          boder: 2,
          p: 5,
          borderColor: "peru",
          bgcolor: "#111",
          color: "white"
        }}
      > Pero que hermoso es MUI
      </Box>

    </Container>
  )
}