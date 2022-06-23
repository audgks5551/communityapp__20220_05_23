import * as React from 'react';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Stack from '@mui/material/Stack';
import { styled } from '@mui/material/styles';

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

export default function BasicStack() {
  return (
    <Box sx={{ width: '100%' }}>
      <Stack spacing={2} className="mt-12">
        <Item>
          <div className='text-xl'>제목임</div>
          <div>asdasdadslkgsdkljgsldk;jglsdkg</div>
        </Item>
        <Item>
          <div className='text-xl'>제목임</div>
          <div>asdasdadslkgsdkljgsldk;jglsdkg53452345234523453245234523452344444444444444444444444452345234523444444444444444444444444523452345234444444444444444444444445234523452344444444444444444444444452345234523444444444444444444444444444444444</div>
        </Item>
        <Item>
          <div className='text-xl'>제목임</div>
          <div>asdasdadslkgsdkljgsldk;jglsdkg4354345345435345345252345</div>
        </Item>
        <Item>
          <div className='text-xl'>제목임</div>
          <div>asdasdadslkgsdkljgsldk;jglsdkg</div>
        </Item>
        
      </Stack>
    </Box>
  );
}
