import { createSlice } from "@reduxjs/toolkit";

const counterSlice = createSlice({
  // Redux는 상태 + 함수(action)를 같이 관리
  name: "counter",
  initialState: {
    value: 0,
  },

  // 자동생성 - dispatch(increase())
  // 자동생성 - dispatch(decrease())
  reducers: {
    increase: (state) => {
      state.value += 1;
    },
    decrease: (state) => {
      state.value -= 1;
    },
  },
});

export const { increase, decrease } = counterSlice.actions;
export default counterSlice.reducer;
