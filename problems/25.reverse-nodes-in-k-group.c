/*
 * @lc app=leetcode id=25 lang=c
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#if 0
#define NULL (void *)0
struct ListNode
{
  int val;
  struct ListNode *next;
};
#endif

struct ListNode *reverseKGroup(struct ListNode *head, int k)
{
  struct ListNode *emptyHead = malloc(sizeof(struct ListNode));
  if (emptyHead == NULL)
  {
    return NULL;
  }
  emptyHead->val = 0;
  emptyHead->next = head;
  struct ListNode *lastParent = NULL;
  struct ListNode *parent = emptyHead;
  struct ListNode *p = emptyHead;
  struct ListNode **lists = malloc(k * sizeof(struct ListNode *));
  if (lists == NULL)
  {
    return NULL;
  }
  for (int i = 0;; i++)
  {
    if ((i - 1) % k == 0)
    {
      if (parent == NULL)
      {
        break;
      }
      struct ListNode *ptr = parent;
      int exitFlag = 0;
      for (int j = 0; j < k; j++)
      {
        lists[k - 1 - j] = ptr->next;
        if (lists[k - 1 - j] == NULL)
        {
          exitFlag = 1;
          break;
        }
        ptr = ptr->next;
      }
      if (exitFlag)
      {
        break;
      }
      struct ListNode *next = ptr->next;
      parent->next = lists[0];
      for (int j = 0; j < k - 1; j++)
      {
        lists[j]->next = lists[j + 1];
      }
      lists[k - 1]->next = next;
      lastParent = parent;
      parent = lists[k - 1];
    }
    if (p == NULL)
    {
      break;
    }
    p = p->next;
  }
  head = emptyHead->next;
  free(emptyHead);
  return head;
}

// @lc code=end
